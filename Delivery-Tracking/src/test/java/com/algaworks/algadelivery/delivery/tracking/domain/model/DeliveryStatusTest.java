package com.algaworks.algadelivery.delivery.tracking.domain.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DeliveryStatusTest {

    @Test
    void draft_canChangeToWaitingForCourier() {
        assertTrue(DeliveryStatus.DRAFT.canChangeTo(DeliveryStatus.WAITING_FOR_COURIER));
    }

    @Test
    void draft_canChangeToInTransit() {
        assertTrue(DeliveryStatus.DRAFT.canNotChangeTo(DeliveryStatus.IN_TRANSIT));
    }
    
    @Test
    void waitingForCourier_canChangeToDelivered() {
        assertTrue(DeliveryStatus.WAITING_FOR_COURIER.canNotChangeTo(DeliveryStatus.DELIVERY));
    }

}
