package com.example.final_task.form;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateSwimmerFormTest {
    public static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void CreateSwimmerFormのnameもstrokeもNULLでない場合errorを返さないこと() {
        CreateSwimmerForm createSwimmerForm = new CreateSwimmerForm("Summer Mclntosh", "IM");
        Set<ConstraintViolation<CreateSwimmerForm>> result =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(createSwimmerForm);
        assertThat((result.size())).isEqualTo(0);
    }

    @Test
    public void CreateSwimmerFormのNameがnullのときにエラーメッセージを返すこと() {
        CreateSwimmerForm createSwimmerForm = new CreateSwimmerForm(null, "IM");
        Set<ConstraintViolation<CreateSwimmerForm>> violations =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(createSwimmerForm);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("Name cannot be null!");
    }

    @Test
    public void CreateSwimmerFormのNameが空文字のときにエラーメッセージを返すこと() {
        CreateSwimmerForm createSwimmerForm = new CreateSwimmerForm("", "IM");
        Set<ConstraintViolation<CreateSwimmerForm>> violations =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(createSwimmerForm);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("Name cannot be null!");
    }

    @Test
    public void CreateSwimmerFormのStrokeがnullのときにエラーメッセージを返すこと() {
        CreateSwimmerForm createSwimmerForm = new CreateSwimmerForm("Summer Mclntosh", null);
        Set<ConstraintViolation<CreateSwimmerForm>> violations =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(createSwimmerForm);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("Stroke cannot be null!");
    }

    @Test
    public void CreateSwimmerFormのStrokeが空文字のときにエラーメッセージを返すこと() {
        CreateSwimmerForm createSwimmerForm = new CreateSwimmerForm("Summer Mclntosh", "");
        Set<ConstraintViolation<CreateSwimmerForm>> violations =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(createSwimmerForm);
        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).extracting("message").containsOnly("Stroke cannot be null!");
    }

    @Test
    public void CreateSwimmerFormのNameとStrokeがnullのときにエラーメッセージを返すこと() {
        CreateSwimmerForm createSwimmerForm = new CreateSwimmerForm(null, null);
        Set<ConstraintViolation<CreateSwimmerForm>> violations =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(createSwimmerForm);
        assertThat(violations.size()).isEqualTo(2);
        assertThat(violations).extracting("message").containsOnly("Name cannot be null!", "Stroke cannot be null!");
    }

    @Test
    public void CreateSwimmerFormのNameとStrokeが空文字のときにエラーメッセージを返すこと() {
        CreateSwimmerForm createSwimmerForm = new CreateSwimmerForm("", "");
        Set<ConstraintViolation<CreateSwimmerForm>> violations =
                Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(createSwimmerForm);
        assertThat(violations.size()).isEqualTo(2);
        assertThat(violations).extracting("message").containsOnly("Name cannot be null!", "Stroke cannot be null!");
    }
}
