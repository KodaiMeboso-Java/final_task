package com.example.final_task.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Swimmer {
    private int id;
    private String name;
    private String stroke;

    public Swimmer(String name, String stroke) {
        this.id = 0;
        this.name = name;
        this.stroke = stroke;
    }
}
