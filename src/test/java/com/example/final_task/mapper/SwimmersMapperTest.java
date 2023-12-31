package com.example.final_task.mapper;

import com.example.final_task.entity.Swimmer;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(
        scripts = {"classpath:/delete-swimmers.sql", "classpath:/insert-swimmers.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
class SwimmersMapperTest {

    @Autowired
    SwimmersMapper swimmersMapper;

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

    @Test
    @Transactional
    void 指定した水泳選手が取得できること() {
        Optional<Swimmer> swimmer = swimmersMapper.findById(1);
        assertThat(swimmer).isEqualTo((Optional.of(new Swimmer(1, "Michael Phelps", "Butterfly"))));
    }

    @Test
    @Transactional
    void 指定したidが存在しない場合に返ってくるデータが空であること() {
        int id = 100;
        Optional<Swimmer> swimmer = swimmersMapper.findById(id);
        assertThat(swimmer).isEmpty();
    }

    @Test
    @Transactional
    void 新しい水泳選手が登録できること() {
        Swimmer swimmer = new Swimmer("Zhang", "Fufei");
        swimmersMapper.create(swimmer);
        Optional<Swimmer> retrievedSwimmer = swimmersMapper.findById(swimmer.getId());
        assertThat(retrievedSwimmer).isPresent();
        assertThat(retrievedSwimmer.get().getName()).isEqualTo(swimmer.getName());
        assertThat(retrievedSwimmer.get().getStroke()).isEqualTo(swimmer.getStroke());
    }

    @Test
    @Transactional
    void 更新した水泳選手の情報が反映されること() {
        Optional<Swimmer> updateSwimmer = swimmersMapper.findById(1);
        assertThat(updateSwimmer).isEqualTo((Optional.of(new Swimmer(1, "Michael Phelps", "Butterfly"))));
        swimmersMapper.update(1, "Sarah Sjostrom", "IM");
        Optional<Swimmer> updatedSwimmer = swimmersMapper.findById(1);
        assertThat(updatedSwimmer).isEqualTo(Optional.of(new Swimmer(1, "Sarah Sjostrom", "IM")));
    }

    @Test
    @Transactional
    void 水泳選手が削除できること() {
        Optional<Swimmer> deleteSwimmer = swimmersMapper.findById(1);
        assertThat(deleteSwimmer).isEqualTo((Optional.of(new Swimmer(1, "Michael Phelps", "Butterfly"))));
        swimmersMapper.delete(1);
        Optional<Swimmer> deletedSwimmer = swimmersMapper.findById(1);
        assertThat(deletedSwimmer).isEmpty();
    }
}
