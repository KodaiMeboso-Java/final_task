package com.example.final_task.mapper;

import com.example.final_task.entity.Swimmer;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SwimmersMapperTest {

    @Autowired
    SwimmersMapper swimmersMapper;

    @Sql(
            scripts = {"classpath:/delete-swimmers.sql", "classpath:/insert-swimmers.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Test
    @Transactional
    void 全ての水泳選手が取得できること() {
        List<Swimmer> swimmers = swimmersMapper.findAll();
        assertThat(swimmers)
                .hasSize(3)
                .contains(
                        new Swimmer(1, "Michael Phelps", "Butterfly"),
                        new Swimmer(2, "Katie Ledecky", "Freestyle"),
                        new Swimmer(3, "Adam Peaty", "Breaststroke")
                );
    }
//
//    @Test
//    void findById() {
//    }
//
//    @Test
//    void create() {
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }
//    }
}
