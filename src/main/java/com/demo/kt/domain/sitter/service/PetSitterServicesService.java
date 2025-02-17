package com.demo.kt.domain.sitter.service;

import com.demo.kt.domain.member.repository.MemberRepository;
import com.demo.kt.domain.sitter.dto.ScheduleDto;
import com.demo.kt.domain.sitter.dto.ServiceDetailResponseDto;
import com.demo.kt.domain.sitter.dto.ServiceRegistrationDto;
import com.demo.kt.domain.sitter.dto.SitterServiceResponseDto;
import com.demo.kt.domain.sitter.model.DogSizeEntity;
import com.demo.kt.domain.sitter.model.PetSitter;
import com.demo.kt.domain.sitter.model.PetSitterServices;
import com.demo.kt.domain.sitter.model.Schedule;
import com.demo.kt.domain.sitter.model.ServiceTypeEntity;
import com.demo.kt.domain.sitter.repository.DogSizeRepository;
import com.demo.kt.domain.sitter.repository.PetSitterServicesRepository;
import com.demo.kt.domain.sitter.repository.ScheduleRepository;
import com.demo.kt.domain.sitter.repository.ServiceTypeRepository;
import com.demo.kt.global.enums.ErrorType;
import com.demo.kt.global.exception.model.CustomException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetSitterServicesService {

    private final PetSitterServicesRepository petSitterServicesRepository;
    private final ServiceTypeRepository serviceTypeRepository;
    private final DogSizeRepository dogSizeRepository;
    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public SitterServiceResponseDto registerService(String email, ServiceRegistrationDto request) {
        PetSitter petSitter = memberRepository.findByEmail(email).orElseThrow(() -> new CustomException(
                        ErrorType.NOT_FOUND_MEMBER_ERROR)).getPetSitter();

        PetSitterServices service = PetSitterServices.builder()
                .price(request.rate())
                .location(petSitter.getLocation())
                .species(petSitter.getSpecies())
                .petSitter(petSitter)
                .build();
        petSitterServicesRepository.save(service); // 먼저 저장해야 ID가 생성됨

        List<ServiceTypeEntity> serviceTypeEntities = request.serviceTypes().stream()
                .map(type -> ServiceTypeEntity.builder()
                        .service(service)
                        .serviceType(type)
                        .build())
                .collect(Collectors.toList());

        List<DogSizeEntity> dogSizeEntities = request.dogSizes().stream()
                .map(size -> DogSizeEntity.builder()
                        .service(service)
                        .dogSize(size)
                        .build())
                .collect(Collectors.toList());

        List<Schedule> scheduleEntities = request.schedule().stream()
        .map(dto -> Schedule.builder()
            .services(service)
            .day(dto.day())  // 요일 (문자열)
            .startTime(dto.startTime()) // "HH:mm" 형태
            .endTime(dto.endTime()) // "HH:mm" 형태
            .build())
        .toList();

        serviceTypeRepository.saveAll(serviceTypeEntities);
        dogSizeRepository.saveAll(dogSizeEntities);
        scheduleRepository.saveAll(scheduleEntities);

        return new SitterServiceResponseDto(service.getId(), service.getLocation(), service.getSpecies(), service.getPrice(), service.getImage());
    }

    public List<SitterServiceResponseDto> myServices(String email) {
        PetSitter petSitter = memberRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MEMBER_ERROR)).getPetSitter();

        return petSitterServicesRepository.findAllByPetSitter(petSitter).stream()
                .map(SitterServiceResponseDto::of).toList();
    }

    @Transactional
    public void deleteService(String email, Long id) {
        PetSitter petSitter = memberRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MEMBER_ERROR)).getPetSitter();

        PetSitterServices petSitterServices = petSitterServicesRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_SERVICE_ERROR));

        if (petSitterServices.getPetSitter().equals(petSitter)) {
            petSitterServicesRepository.delete(petSitterServices);
        }
    }

    public ServiceDetailResponseDto getDetail(String email, Long id) {
        PetSitter petSitter = memberRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MEMBER_ERROR)).getPetSitter();

        PetSitterServices petSitterServices = petSitterServicesRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_SERVICE_ERROR));

        List<Schedule> schedules = scheduleRepository.findAllByServices(petSitterServices);

        return ServiceDetailResponseDto.of(petSitter, petSitterServices, schedules.stream().map(
                ScheduleDto::of).toList());
    }

}
