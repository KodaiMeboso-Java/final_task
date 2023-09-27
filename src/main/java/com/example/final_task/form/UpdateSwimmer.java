package com.example.final_task.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSwimmer {
    @NotBlank(message = "Name cannot be null!")
    private String name;
    @NotBlank(message = "Stroke cannot be null!")
    private String stroke;
}
