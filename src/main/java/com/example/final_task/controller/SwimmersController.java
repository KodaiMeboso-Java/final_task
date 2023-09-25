package com.example.final_task.controller;

import com.example.final_task.entity.Swimmer;
import com.example.final_task.form.CreateSwimmer;
import com.example.final_task.mapper.SwimmersMapper;
import com.example.final_task.service.SwimmersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class SwimmersController {
    public final SwimmersService swimmersService;

    public final SwimmersMapper swimmersMapper;

    public SwimmersController(SwimmersMapper swimmersMapper, SwimmersService swimmersService) {
        this.swimmersMapper = swimmersMapper;
        this.swimmersService = swimmersService;
    }

    @GetMapping("/swimmers")
    public List<Swimmer> swimmers() {
        return swimmersService.findAll();
    }

    @GetMapping("/swimmers/{id}")
    public Swimmer selectOneSwimmer(@PathVariable("id") int id) {
        return swimmersService.findById(id);
    }

    @PostMapping("/swimmers")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Validated CreateSwimmer createSwimmer, UriComponentsBuilder uriComponentsBuilder) {
        Swimmer swimmer = swimmersService.create(createSwimmer.getName(), createSwimmer.getStroke());
        URI uri = uriComponentsBuilder
                .path("/swimmers/{id}")
                .buildAndExpand(swimmer.getId())
                .toUri();
        return ResponseEntity.created(uri).body(Map.of("message", "data successfully created"));
    }

    @PatchMapping("/swimmers/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody @Validated CreateSwimmer createSwimmer) {
        swimmersService.update(id, createSwimmer.getName(), createSwimmer.getStroke());
        return ResponseEntity.ok("date successfully updated!");
    }
}

