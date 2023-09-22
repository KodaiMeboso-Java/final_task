package com.example.final_task.service;

import com.example.final_task.entity.Swimmers;
import com.example.final_task.form.CreateSwimmer;

import java.util.List;

public interface SwimmersService {
    List<Swimmers> findAll();

    Swimmers findById(int id);

    Swimmers create(String name,String stroke);

}
