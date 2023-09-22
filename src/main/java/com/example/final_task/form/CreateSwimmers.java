package com.example.final_task.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSwimmers {
    @NotBlank
    private String name;
    @NotBlank
    private String stroke;
}
