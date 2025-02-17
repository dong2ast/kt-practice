package com.demo.kt.domain.sitter.model;

import com.demo.kt.domain.sitter.dto.ServiceDetailDto;
import com.demo.kt.global.common.model.BaseTimeEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetSitterServices extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_sitter_services_id")
    private Long id;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceTypeEntity> serviceTypes;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DogSizeEntity> dogSizes;

    private String location;
    private String species;
    private Long price;
    private String image;

    @OneToMany(mappedBy = "services", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules;

    @ManyToOne
    @JoinColumn(name = "pet_sitter_id")
    private PetSitter petSitter;

    public void update(ServiceDetailDto serviceDetailDto, List<Schedule> schedules) {
        this.location = serviceDetailDto.location();
        this.species = serviceDetailDto.species();
        this.price = serviceDetailDto.price();
        this.schedules.addAll(schedules);
    }
}
