package com.example.final_task.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSwimmerForm{
    @NotBlank(message = "Name cannot be null!")
    private String name;
    @NotBlank(message = "Stroke cannot be null!")
    private String stroke;

    public CreateSwimmerForm(String name, String stroke) {
        this.name = name;
        this.stroke = stroke;
    }
}
