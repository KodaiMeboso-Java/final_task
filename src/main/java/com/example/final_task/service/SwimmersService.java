package com.example.final_task.service;

import com.example.final_task.entity.Swimmers;

import java.util.List;

public interface SwimmersService {
    List<Swimmers> findAll();

    Swimmers findById(int id);



}
