package com.saltatorv.notification.manager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        createDeliveryAttempt(1);

        //when
        sendAttempt();

        //then
        assertHasNotRemainingSendAttempts();
    }

    @Test
    public void testDeliveryAttemptShouldNotSendAttemptIfHasNotRemainingSendAttempts() {
        // given
        createDeliveryAttempt(1);
        sendAttempt();

        //when
        assertThrows(RuntimeException.class, () -> sendAttempt());

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
