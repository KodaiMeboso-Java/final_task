package com.example.final_task.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Swimmer swimmer = (Swimmer) o;
        return id == swimmer.id &&
                Objects.equals(name, swimmer.name) &&
                Objects.equals(stroke, swimmer.stroke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stroke);
    }

}
