package com.example.final_task.service;

import com.example.final_task.entity.Swimmer;

import java.util.List;

public interface SwimmersService {
    List<Swimmer> findAll();

    Swimmer findById(int id);

    void create(Swimmer swimmer);

}
