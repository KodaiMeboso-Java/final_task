package com.example.final_task.form;

import com.example.final_task.mapper.SwimmersMapper;
import com.example.final_task.service.SwimmersServiceImpl;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class UpdateSwimmerFormTest {
    public static Validator validator;

    SwimmersServiceImpl swimmersServiceImpl;

    SwimmersMapper swimmersMapper;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void UpdateSwimmerFormのidとnameとstrokeも正常値である場合errorを返さないこと() {
        UpdateSwimmerForm updateSwimmerForm = new UpdateSwimmerForm(1, "r4EpE1t", "101PK1a");
        Set<ConstraintViolation<UpdateSwimmerForm>> result =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(updateSwimmerForm);
        assertThat((result.size())).isEqualTo(0);
    }

    @Test
    public void UpdateSwimmerFormのnameがnullのときにerrorを返すこと() throws ParseException {
        UpdateSwimmerForm updateSwimmerForm = new UpdateSwimmerForm(1, null, "cAmfag");
        Set<ConstraintViolation<UpdateSwimmerForm>> violations =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(updateSwimmerForm);
        assertThat(violations.size()).isEqualTo(1);
        violations.forEach(action -> {
            assertThat(action.getPropertyPath().toString()).isEqualTo("nameOrStrokeNotBlank");
            assertThat(action.getMessage()).isEqualTo("Name or stroke cannot null!");
        });
    }

    @Test
    public void UpdateSwimmerFormのnameが空文字のときにerrorを返すこと() throws ParseException {
        UpdateSwimmerForm updateSwimmerForm = new UpdateSwimmerForm(1, "", "9P2");
        Set<ConstraintViolation<UpdateSwimmerForm>> violations =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(updateSwimmerForm);
        assertThat(violations.size()).isEqualTo(1);
        violations.forEach(action -> {
            assertThat(action.getPropertyPath().toString()).isEqualTo("nameOrStrokeNotBlank");
            assertThat(action.getMessage()).isEqualTo("Name or stroke cannot null!");
        });
    }

    @Test
    public void UpdateSwimmerFormのstrokeがnullのときにerrorを返すこと() throws ParseException {
        UpdateSwimmerForm updateSwimmerForm = new UpdateSwimmerForm(1, "5ZeeRR", null);
        Set<ConstraintViolation<UpdateSwimmerForm>> violations =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(updateSwimmerForm);
        assertThat(violations.size()).isEqualTo(1);
        violations.forEach(action -> {
            assertThat(action.getPropertyPath().toString()).isEqualTo("nameOrStrokeNotBlank");
            assertThat(action.getMessage()).isEqualTo("Name or stroke cannot null!");
        });
    }

    @Test
    public void UpdateSwimmerFormのstrokeが空文字のときにerrorを返すこと() throws ParseException {
        UpdateSwimmerForm updateSwimmerForm = new UpdateSwimmerForm(1, "lt6", "");
        Set<ConstraintViolation<UpdateSwimmerForm>> violations =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(updateSwimmerForm);
        assertThat(violations.size()).isEqualTo(1);
        violations.forEach(action -> {
            assertThat(action.getPropertyPath().toString()).isEqualTo("nameOrStrokeNotBlank");
            assertThat(action.getMessage()).isEqualTo("Name or stroke cannot null!");
        });
    }
}
