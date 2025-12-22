package com.saltatorv.notification.manager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeliveryAttemptTest {

    DeliveryAttempt attempt;

    @Test
    public void testDeliveryAttemptHasRemainingSendAttempts() {
        // given
        createDeliveryAttempt(3);

        //when
        sendAttempt();

        //then
        assertHasRemainingSendAttempts();
    }

    @Test
    public void testDeliveryAttemptHasNotRemainingSendAttempts() {
        // given
        createDeliveryAttempt(0);

        //when
        sendAttempt();

        //then
        assertHasNotRemainingSendAttempts();
    }



    private void createDeliveryAttempt(int maxAttemptsCounter) {
        attempt = new DeliveryAttempt(maxAttemptsCounter);
    }

    private void sendAttempt() {
        attempt.sendAttempt();
    }

    private void assertHasRemainingSendAttempts() {
        assertTrue(attempt.hasRemainingSendAttempts());
    }

    private void assertHasNotRemainingSendAttempts() {
        assertFalse(attempt.hasRemainingSendAttempts());
    }

}
