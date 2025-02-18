package com.demo.kt.domain.sitter.controller;

import com.demo.kt.domain.sitter.dto.ServiceDetailDto;
import com.demo.kt.domain.sitter.dto.ServiceDetailResponseDto;
import com.demo.kt.domain.sitter.dto.ServiceRegistrationDto;
import com.demo.kt.domain.sitter.dto.SitterHomeDto;
import com.demo.kt.domain.sitter.dto.SitterProfileResponseDto;
import com.demo.kt.domain.sitter.dto.SitterProfileUpdateDto;
import com.demo.kt.domain.sitter.dto.SitterRegistrationDto;
import com.demo.kt.domain.sitter.dto.SitterServiceResponseDto;
import com.demo.kt.domain.sitter.service.PetSitterServicesService;
import com.demo.kt.domain.sitter.service.SitterService;
import com.demo.kt.global.common.dto.ApiResponse;
import com.demo.kt.global.enums.SuccessType;
import java.security.Principal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sitters")
public class SitterController implements SitterApi {

    private final SitterService sitterService;
    private final PetSitterServicesService servicesService;

    @Override
    @PostMapping
    public ResponseEntity<ApiResponse<?>> registration(Principal principal,
            @RequestBody SitterRegistrationDto sitterRegistrationDto) {
        sitterService.registration(principal.getName(), sitterRegistrationDto);
        return ResponseEntity.ok(ApiResponse.success(SuccessType.SITTER_REGISTRATION_SUCCESS));
    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<SitterHomeDto>> home(Principal principal) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.SITTER_HOME_SUCCESS,
                sitterService.home(principal.getName())));
    }

    @Override
    @GetMapping("/profile")
    public ResponseEntity<ApiResponse<SitterProfileResponseDto>> profile(Principal principal) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.SITTER_PROFILE_SUCCESS,
                sitterService.profile(principal.getName())));
    }

    @Override
    @PutMapping
    public ResponseEntity<ApiResponse<?>> update(Principal principal,
            @RequestBody SitterProfileUpdateDto sitterProfileUpdateDto) {
        sitterService.update(principal.getName(), sitterProfileUpdateDto);
        return ResponseEntity.ok(ApiResponse.success(SuccessType.SITTER_PROFILE_UPDATE_SUCCESS));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ApiResponse<?>> delete(Principal principal) {
        sitterService.delete(principal.getName());
        return ResponseEntity.ok(ApiResponse.success(SuccessType.DELETE_SITTER_PROFILE_SUCCESS));
    }

    @Override
    @PostMapping("/services/registration")
    public ResponseEntity<ApiResponse<?>> serviceRegistration(Principal principal,
            @RequestBody ServiceRegistrationDto serviceRegistrationDto) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.CREATE_SERVICE_SUCCESS,
                servicesService.registerService(principal.getName(), serviceRegistrationDto)));
    }

    @Override
    @GetMapping("/services")
    public ResponseEntity<ApiResponse<List<SitterServiceResponseDto>>> myServices(
            Principal principal) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.GET_SITTER_SERVICE_SUCCESS,
                servicesService.myServices(principal.getName())));
    }

    @Override
    @DeleteMapping("/services/{id}")
    public ResponseEntity<ApiResponse<?>> deleteService(Principal principal,
            @PathVariable("id") Long id) {
        servicesService.deleteService(principal.getName(), id);
        return ResponseEntity.ok(ApiResponse.success(SuccessType.DELETE_SERVICE_SUCCESS));
    }

    @Override
    @GetMapping("/services/{id}")
    public ResponseEntity<ApiResponse<ServiceDetailResponseDto>> serviceDetail(Principal principal,
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.GET_SERVICE_DETAIL_SUCCESS,
                servicesService.getDetail(principal.getName(), id)));
    }

    @Override
    @PutMapping("/services")
    public ResponseEntity<ApiResponse<?>> updateServiceDetail(Principal principal,
            @RequestBody ServiceDetailDto serviceDetailDto) {
        servicesService.updateDetail(serviceDetailDto);
        return ResponseEntity.ok(
                ApiResponse.success(SuccessType.UPDATE_SERVICE_DETAIL_SUCCESS));
    }

    @Override
    @PostMapping("/services/{id}")
    public ResponseEntity<ApiResponse<?>> serviceRequest(Principal principal, @PathVariable("id") Long serviceId) {
        servicesService.bookService(principal.getName(), serviceId);
        return ResponseEntity.ok(ApiResponse.success(SuccessType.CREATE_BOOK_SUCCESS));
    }
}
