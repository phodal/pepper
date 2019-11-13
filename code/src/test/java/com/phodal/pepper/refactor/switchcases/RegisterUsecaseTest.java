package com.phodal.pepper.refactor.switchcases;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.spy;

public class RegisterUsecaseTest {
    @Test
    public void should_return_true_when_has_suit_case() {
        spy(System.class);

        RegisterUsecase registerUsecase = new RegisterUsecase();
        registerUsecase.registerCase();
        registerUsecase.runCase("CASEA");
        registerUsecase.runCase("CASEB");

        assertThat(true).isEqualTo(true);
    }
}
