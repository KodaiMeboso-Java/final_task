package com.example.final_task.controller;

import com.example.final_task.entity.Swimmers;
import com.example.final_task.mapper.SwimmersMapper;
import com.example.final_task.service.SwimmersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SwimmersController {
    public final SwimmersService swimmersService;

    public final SwimmersMapper swimmersMapper;

    public SwimmersController(SwimmersMapper swimmersMapper, SwimmersService swimmersService) {
        this.swimmersMapper = swimmersMapper;
        this.swimmersService = swimmersService;
    }

    @GetMapping("/swimmers")
    public List<Swimmers> swimmers() {
        return swimmersService.findAll();
    }

    @GetMapping("/swimmers/{id}")
    public Swimmers selectOneSwimmer(@PathVariable("id") int id) {
        return swimmersService.findById(id);
    }

}
