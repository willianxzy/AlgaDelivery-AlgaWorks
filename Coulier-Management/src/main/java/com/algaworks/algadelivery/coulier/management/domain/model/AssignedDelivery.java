package com.algaworks.algadelivery.coulier.management.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class AssignedDelivery {

    @EqualsAndHashCode.Include
    private UUID id;

    private OffsetDateTime assignedAt;

    static AssignedDelivery pending(UUID deliveryId){
        AssignedDelivery assignedDelivery = new AssignedDelivery();
        assignedDelivery.setId(UUID.randomUUID());
        assignedDelivery.setAssignedAt(OffsetDateTime.now());
        return assignedDelivery;
    }  

}
