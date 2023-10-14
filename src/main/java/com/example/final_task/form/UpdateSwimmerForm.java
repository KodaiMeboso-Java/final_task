package com.example.final_task.form;

import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSwimmerForm {
    private String name;
    private String stroke;

    @AssertTrue(message = "name or stroke cannot null!")
    public boolean isNameOrStrokeNotBlank() {
        // nameかstrokeがnullまたは空文字または半角スペースのときにfalseを返す
        if (name == null || stroke == null) {
            return false;
        } else return !name.isBlank() && !stroke.isBlank();
    }
}
