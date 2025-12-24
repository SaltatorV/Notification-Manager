package com.saltatorv.notification.manager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryAttemptTest {

    DeliveryAttempt attempt;

    @Test
    public void testShouldRegisterSuccessfulAttempt() {
        // given
        createDeliveryAttempt(3);

        //when
        registerSuccessfulAttempt();

        //then
        assertDeliveryWasSuccessful();
    }


    @Test
    public void testShouldRegisterFailedAttempt() {
        // given
        createDeliveryAttempt(3);

        //when
        registerFailedAttempt();

        //then
        assertHasRemainingSendAttempts();
        assertDeliveryWasFailed();
    }

    @Test
    public void testDeliverWasSuccessful() {
        // given
        createDeliveryAttempt(3);

        //when
        registerFailedAttempt();
        waitSomeTime();
        registerFailedAttempt();
        waitSomeTime();
        registerSuccessfulAttempt();

        //then
        assertNoRemainingSendAttempts();
        assertDeliveryWasSuccessful();
    }

    @Test
    public void testShouldHaveNoRemainingSendAttemptsWhenAttemptWasSuccessful() {
        //given
        createDeliveryAttempt(3);

        //when
        registerSuccessfulAttempt();

        //then
        assertNoRemainingSendAttempts();
    }

    @Test
    public void shouldHaveNoRemainingSendAttemptsWhenOneOfAttemptsWasSuccessful() {
        //given
        createDeliveryAttempt(3);
        registerFailedAttempt();

        //when
        registerSuccessfulAttempt();

        //then
        assertNoRemainingSendAttempts();
    }

    @Test
    public void testShouldThrowExceptionWhenTryRegisterAttemptWhenThereIsNoRemainingAttempts() {
        //given
        createDeliveryAttempt(1);
        registerFailedAttempt();

        //when
        assertThrows(RuntimeException.class, this::registerSuccessfulAttempt);

        //then
        assertNoRemainingSendAttempts();
        assertDeliveryWasFailed();
    }

    @Test
    public void testShouldThrowExceptionWhenTryRegisterSameAttempt() {
        //given
        createDeliveryAttempt(2);

        //when
        registerSuccessfulAttempt();
        assertThrows(RuntimeException.class, this::registerSuccessfulAttempt);

        //then
        assertDeliveryWasSuccessful();
    }

    @Test
    public void testShouldThrowExceptionWhenTryRegisterAttemptWhenThereIsNoRemaingAttempts() {
        //given
        createDeliveryAttempt(1);

        //when
        registerFailedAttempt();
        assertThrows(RuntimeException.class, this::registerSuccessfulAttempt);

        //then
        assertDeliveryWasFailed();
        assertNoRemainingSendAttempts();
    }

    @Test
    public void testShouldThrowExceptionWhenTryCreateDeliveryAttemptWithNegativeValue() {
        //given

        //when
        assertThrows(RuntimeException.class, () -> createDeliveryAttempt(-1));

        //then
        assertNull(attempt);
    }

    @Test
    public void testShouldThrowExceptionWhenTryCreateDeliveryAttemptWithZeroValue() {
        //given

        //when
        assertThrows(RuntimeException.class, () -> createDeliveryAttempt(0));

        //then
        assertNull(attempt);
    }

    private void createDeliveryAttempt(int maxAttemptsCounter) {
        attempt = new DeliveryAttempt(maxAttemptsCounter);
    }

    private void registerSuccessfulAttempt() {
        attempt.registerAttempt(AttemptResult.createForSuccess());
    }

    private void registerFailedAttempt() {
        attempt.registerAttempt(AttemptResult.createForFailure("Fail"));
    }

    private void waitSomeTime() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    private void assertHasRemainingSendAttempts() {
        assertTrue(attempt.hasRemainingSendAttempts());
    }

    private void assertNoRemainingSendAttempts() {
        assertFalse(attempt.hasRemainingSendAttempts());
    }

    private void assertDeliveryWasSuccessful() {
        assertTrue(attempt.wasSuccessful());
    }

    private void assertDeliveryWasFailed() {
        assertFalse(attempt.wasSuccessful());
    }

}
