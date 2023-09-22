package com.example.final_task.mapper;

import com.example.final_task.entity.Swimmers;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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
        @Options(useGeneratedKeys = true, keyProperty = ("id"))
        Swimmers create(@Param("name") String name, @Param("stroke") String stroke);
}
