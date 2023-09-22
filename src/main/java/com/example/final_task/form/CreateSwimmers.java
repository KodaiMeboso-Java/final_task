package com.example.final_task.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSwimmers {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String stroke;
}
