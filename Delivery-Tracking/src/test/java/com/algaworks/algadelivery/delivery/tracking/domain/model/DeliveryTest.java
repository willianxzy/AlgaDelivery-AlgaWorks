package com.algaworks.algadelivery.delivery.tracking.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.algaworks.algadelivery.delivery.tracking.domain.exception.DomainException;
import com.algaworks.algadelivery.delivery.tracking.domain.model.Delivery.PreparationDetails;

public class DeliveryTest {
    
    @Test
    public void shouldChangeToPlaced() {
        Delivery delivery = Delivery.draft();
        delivery.editPreparationDetails(createdValidPreparationDetails());
        delivery.place();

        assertEquals(DeliveryStatus.WAITING_FOR_COURIER, delivery.getStatus());
        assertNotNull(delivery.getPlacedAt());
    }

        @Test
    public void shouldNotPlaced() {
        Delivery delivery = Delivery.draft();
        assertThrows(DomainException.class, () -> {
            delivery.place();
        });

        assertEquals(DeliveryStatus.DRAFT, delivery.getStatus());
        assertNull(delivery.getPlacedAt());
    }

    private PreparationDetails createdValidPreparationDetails() {
        ContactPoint sender = ContactPoint.builder()
                .zipCode("12345-000")
                .street("Sender Street")
                .number("123")
                .complement("Apt 1")
                .name("Sender")
                .phone("(12) 3456-7890")
                .build();

        ContactPoint recipient = ContactPoint.builder()
                .zipCode("54321-000")
                .street("Recipient Street")
                .number("456")
                .complement("Apt 2")
                .name("Recipient")
                .phone("(12) 9876-5432")
                .build();

        return Delivery.PreparationDetails.builder()
                .sender(sender)
                .recipient(recipient)
                .distanceFee(new BigDecimal("10.00"))
                .courierPayout(new BigDecimal("5.00"))
                .expectedDeliveryTime(Duration.ofHours(1))
                .build();
    }
}
