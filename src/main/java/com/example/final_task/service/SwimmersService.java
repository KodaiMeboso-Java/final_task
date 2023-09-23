package com.example.final_task.service;

import com.example.final_task.entity.Swimmer;
import com.example.final_task.form.CreateSwimmer;

import java.util.List;

public interface SwimmersService {
    List<Swimmer> findAll();

    Swimmer findById(int id);

    Swimmer create(CreateSwimmer createSwimmer);

}
