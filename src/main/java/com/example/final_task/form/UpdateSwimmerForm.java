package com.example.final_task.form;

import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSwimmerForm {
    private int id;
    private String name;
    private String stroke;

    public UpdateSwimmerForm(int id, String name, String stroke) {
        this.id = id;
        this.name = name;
        this.stroke = stroke;
    }

    @AssertTrue(message = "Name or stroke cannot null!")
    public boolean isNameOrStrokeNotBlank() {
        if (name == null || stroke == null) {
            return false;
        } else return !name.isBlank() && !stroke.isBlank();
    }
}
