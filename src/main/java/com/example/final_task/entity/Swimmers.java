package com.example.final_task.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Swimmers {
    private int id;
    private String name;
    private String stroke;

    public Swimmers(int id, String name, String stroke) {
        this.id = id;
        this.name = name;
        this.stroke = stroke;
    }
}
