package com.example.final_task.form;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CreateSwimmerTest {
    Validator validator;

    @Test
    public void 水泳選手を登録できること() {
        CreateSwimmer createSwimmer = new CreateSwimmer("72OkyQQ", "rp66Tv");
        Errors errors = new BeanPropertyBindingResult(createSwimmer, "createSwimmer");
        validator.validate(createSwimmer, errors);
        assertThat(errors.hasErrors()).isEqualTo(false);
    }

    @Test
    public void Nameがnullのときにエラーメッセージを返すこと() {
        CreateSwimmer createSwimmer = new CreateSwimmer("", "3b3nCK");
        Errors errors = new BeanPropertyBindingResult(createSwimmer, "createSwimmer");
        validator.validate(createSwimmer, errors);
        assertThat(errors.hasErrors()).isEqualTo(false);
    }

    @Test
    public void Strokeがnullのときにエラーメッセージを返すこと() {
        CreateSwimmer createSwimmer = new CreateSwimmer("rwd8", "");
        Errors errors = new BeanPropertyBindingResult(createSwimmer, "createSwimmer");
        validator.validate(createSwimmer, errors);
        assertThat(errors.hasErrors()).isEqualTo(false);
    }

    @Test
    public void NameとStrokeがnullのときにエラーメッセージを返すこと() {
        CreateSwimmer createSwimmer = new CreateSwimmer("", "");
        Errors errors = new BeanPropertyBindingResult(createSwimmer, "createSwimmer");
        validator.validate(createSwimmer, errors);
        assertThat(errors.hasErrors()).isEqualTo(false);
    }
}

