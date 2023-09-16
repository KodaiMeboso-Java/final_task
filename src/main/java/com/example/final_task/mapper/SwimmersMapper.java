package com.example.final_task.mapper;

import com.example.final_task.entity.Swimmers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SwimmersMapper {
    @Select("SELECT * FROM swimmers")
    List<Swimmers> findAll();

    @Select("SELECT * FROM swimmers WHERE id = #{id}")
    Optional<Swimmers> findById(int id);
}
