package com.example.final_task.service;

import com.example.final_task.entity.Swimmer;
import com.example.final_task.form.CreateSwimmer;
import org.apache.catalina.authenticator.SavedRequest;

import java.util.List;

public interface SwimmersService {
    List<Swimmer> findAll();

    Swimmer findById(int id);

    Swimmer create(String name, String stroke);

    void update(int id, String name, String stroke);

    void delete(int id);

}
