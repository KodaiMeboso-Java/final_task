package com.example.final_task.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@EqualsAndHashCode
@Getter
@Setter
public class Swimmer {
    private int id;
    private String name;
    private String stroke;

    public Swimmer(int id, String name, String stroke) {
        this.id = id;
        this.name = name;
        this.stroke = stroke;
    }

    public Swimmer(String name, String stroke) {
        this.id = 0;
        this.name = name;
        this.stroke = stroke;
    }
}
