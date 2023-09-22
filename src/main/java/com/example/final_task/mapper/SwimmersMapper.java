package com.example.final_task.mapper;

import com.example.final_task.entity.Swimmers;
import com.example.final_task.form.CreateSwimmers;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SwimmersMapper {
    @Select("SELECT * FROM swimmers")
    List<Swimmers> findAll();

    @Select("SELECT * FROM swimmers WHERE id = #{id}")
    Optional<Swimmers> findById(int id);

    @Insert("INSERT INTO swimmers (name, stroke) VALUES (#{name},#{stroke})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(CreateSwimmers createSwimmers);
}
