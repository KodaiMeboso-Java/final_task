package com.example.final_task.form;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSwimmer {
    private String name;
    private String stroke;

    @AssertTrue(message = "name or stroke cannot null!")
    public boolean isNameOrStrokeNotBlank() {
        // givenNameかfamilyNameがnullまたは空文字または半角スペースのときにfalseを返す
        if (name == null || stroke == null) {
            return false;
        } else if (name.isBlank() || stroke.isBlank()) {
            return false;
        }
        return true;
    }
}
