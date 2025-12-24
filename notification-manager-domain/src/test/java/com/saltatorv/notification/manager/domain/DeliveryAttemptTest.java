package com.saltatorv.notification.manager.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryAttemptTest {

    DeliveryAttempt attempt;
    AttemptResult attemptResult;

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

    @Test
    public void testShouldThrowExceptionWhenTryGetLatestAttemptResultWhenThereIsNotAnyAttempt() {
        //given
        createDeliveryAttempt(3);

        //when
        assertThrows(RuntimeException.class, this::getLatestAttemptResult);

        //then
        assertNull(attemptResult);
    }

    @Test
    public void testShouldReturnLatestSuccessfulAttemptResult() {
        //given
        createDeliveryAttempt(3);
        registerSuccessfulAttempt();

        //when
        getLatestAttemptResult();

        //then
        assertAttemptResultWasSuccessful();
    }

    @Test
    public void testShouldReturnLatestFailedAttemptResult() {
        //given
        var error = "Error...";
        createDeliveryAttempt(3);
        registerFailedAttempt(error);

        //when
        getLatestAttemptResult();

        //then
        assertAttemptResultWasFailed(error);
    }

    @Test
    public void testShouldReturnLatestAttemptResultWhenThereIsFewOfAttempts() {
        //given
        createDeliveryAttempt(3);
        registerFailedAttempt();
        waitSomeTime();
        registerFailedAttempt();
        waitSomeTime();
        registerSuccessfulAttempt();

        //when
        getLatestAttemptResult();

        //then
        assertAttemptResultWasSuccessful();
    }

    @Test
    public void testShouldReturnLatestFailedAttemptResultWhenThereIsOnlyFailedAttempts() {
        //given
        createDeliveryAttempt(3);
        registerFailedAttempt("Error-1");
        waitSomeTime();
        registerFailedAttempt("Error-2");
        waitSomeTime();
        registerFailedAttempt("Error-3");

        //when
        getLatestAttemptResult();

        //then
        assertAttemptResultWasFailed("Error-3");
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

    private void registerFailedAttempt(String error) {
        attempt.registerAttempt(AttemptResult.createForFailure(error));
    }

    private void getLatestAttemptResult() {
        attemptResult = attempt.getLatestAttemptResult();
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

    private void assertAttemptResultWasSuccessful() {
        assertTrue(attemptResult.isWasSuccessful());
        assertTrue(attemptResult.getExceptionMessage().isEmpty());
    }

    private void assertAttemptResultWasFailed(String error) {
        assertFalse(attemptResult.isWasSuccessful());
        assertEquals(error, attemptResult.getExceptionMessage());
    }

}
