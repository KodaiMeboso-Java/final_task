package com.example.final_task.service;

import com.example.final_task.entity.Swimmer;
import com.example.final_task.exception.ResourceNotFoundException;
import com.example.final_task.form.CreateSwimmer;
import com.example.final_task.mapper.SwimmersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SwimmersServiceImpl implements SwimmersService {

    SwimmersMapper swimmersMapper;

    public SwimmersServiceImpl(SwimmersMapper swimmersMapper) {
        this.swimmersMapper = swimmersMapper;
    }

    public List<Swimmer> findAll() {
        return swimmersMapper.findAll();
    }

    @Override
    public Swimmer findById(int id) {
        Optional<Swimmer> swimmer = this.swimmersMapper.findById(id);
        return swimmer.orElseThrow(() -> new ResourceNotFoundException("cannot find data!!"));
    }

    @Override
    public Swimmer create(CreateSwimmer createSwimmer) {
        Swimmer swimmer = new Swimmer(createSwimmer.getName(), createSwimmer.getStroke());
        swimmersMapper.create(swimmer);
        return swimmer;
    }
}
