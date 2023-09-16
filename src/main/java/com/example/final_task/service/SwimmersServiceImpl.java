package com.example.final_task.service;

import com.example.final_task.entity.Swimmers;
import com.example.final_task.exception.ResourceNotFoundException;
import com.example.final_task.mapper.SwimmersMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SwimmersServiceImpl implements SwimmersService {
    SwimmersMapper swimmersMapper;

    public SwimmersServiceImpl(SwimmersMapper swimmersMapper) {
        this.swimmersMapper = swimmersMapper;
    }

    public List<Swimmers> findAll() {
        return swimmersMapper.findAll();
    }

    @Override
    public Swimmers findById(int id) {
        Optional<Swimmers> swimmers = this.swimmersMapper.findById(id);
        return swimmers.orElseThrow(() -> new ResourceNotFoundException("cannot find data!!"));
    }
}
