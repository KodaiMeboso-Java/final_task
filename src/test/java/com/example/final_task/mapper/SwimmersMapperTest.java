package com.example.final_task.mapper;

import com.example.final_task.entity.Swimmer;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SwimmersMapperTest {

    @Autowired
    SwimmersMapper swimmersMapper;

    @Test
    @Sql(
            scripts = {"/databases/insert-swimmers.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Transactional
    void 全ての水泳選手が取得できること() {
        List<Swimmer> swimmers = swimmersMapper.findAll();
        assertThat(swimmers)
                .hasSize(1)
                .contains(
                        new Swimmer(1, "gg9eGx", "g7p1"),
                        new Swimmer(2, "6sc", "1J7mzyS"),
                        new Swimmer(3, "9eGx", "g7FF1")
                );
    }

    @Test
    void findById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}