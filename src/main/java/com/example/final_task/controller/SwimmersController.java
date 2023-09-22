package com.example.final_task.controller;

import com.example.final_task.entity.Swimmers;
import com.example.final_task.form.CreateSwimmer;
import com.example.final_task.mapper.SwimmersMapper;
import com.example.final_task.service.SwimmersService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Swimmers> swimmers() {
        return swimmersService.findAll();
    }

    @GetMapping("/swimmers/{id}")
    public Swimmers selectOneSwimmer(@PathVariable("id") int id) {
        return swimmersService.findById(id);
    }

    @PostMapping("/swimmers")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Validated CreateSwimmer createSwimmer, UriComponentsBuilder uriComponentsBuilder) {
        Swimmers swimmers =  swimmersService.create(createSwimmer.getName(),createSwimmer.getStroke());
        URI uri = uriComponentsBuilder
                .path("/swimmers/{id}")
                .buildAndExpand(swimmers.getId())
                .toUri();
        return ResponseEntity.created(uri).body(Map.of("message", "name successfully created"));
    }
}

