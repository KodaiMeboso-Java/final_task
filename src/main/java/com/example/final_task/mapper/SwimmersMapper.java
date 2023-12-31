package com.example.final_task.mapper;

import com.example.final_task.entity.Swimmer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SwimmersMapper {
    @Select("SELECT * FROM swimmers")
    List<Swimmer> findAll();

    @Select("SELECT * FROM swimmers WHERE id = #{id}")
    Optional<Swimmer> findById(int id);

    @Insert("INSERT INTO swimmers (name, stroke) VALUES (#{name},#{stroke})")
    @Options(useGeneratedKeys = true, keyProperty = ("id"))
    void create(Swimmer swimmer);

    @Update("UPDATE swimmers SET name = #{name}, stroke= #{stroke} WHERE id = #{id}")
    void update(int id, String name, String stroke);

    @Delete("DELETE FROM swimmers WHERE id = #{id}")
    void delete(int id);
}
