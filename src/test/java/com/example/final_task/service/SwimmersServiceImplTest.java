package com.example.final_task.service;

import com.example.final_task.entity.Swimmer;
import com.example.final_task.exception.ResourceNotFoundException;
import com.example.final_task.mapper.SwimmersMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SwimmersServiceImplTest {
    @InjectMocks
    SwimmersServiceImpl swimmersServiceImpl;

    @Mock
    SwimmersMapper swimmersMapper;

    @Test
    public void 存在する水泳選手がすべて取得できること() {
        List<Swimmer> swimmerList = List.of(
                new Swimmer(1, "meboso kodai", "breaststroke"),
                new Swimmer(2, "ikee rikkako", "butterfly"),
                new Swimmer(3, "irie ryosuke", "backstroke")
        );
        doReturn(swimmerList).when(swimmersMapper).findAll();
        //テスト対象メソッドの呼び出し
        List<Swimmer> actual = swimmersServiceImpl.findAll();
        assertThat(actual).isEqualTo(swimmerList);
        verify(swimmersMapper, times(1)).findAll();
    }

    @Test
    public void 存在するIdを指定したときに水泳選手を取得できること() {
        doReturn(Optional.of(new Swimmer(1, "meboso", "breaststroke"))).when(swimmersMapper).findById(1);

        Swimmer actual = swimmersServiceImpl.findById(1);
        assertThat(actual).isEqualTo(new Swimmer(1, "meboso", "breaststroke"));
        verify(swimmersMapper, times(1)).findById(1);
    }
    @Test
    public void 存在しないIDを指定したときにResourceNotFoundExceptionが発生すること() {
        doReturn(Optional.empty()).when(swimmersMapper).findById(100);

        assertThatThrownBy(() -> swimmersServiceImpl.findById(100))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("cannot find data!!");
    }

    @Test
    public void 水泳選手を登録できること() {
        doNothing().when(swimmersMapper).create(any(Swimmer.class));

        Swimmer swimmer = new Swimmer("seto daiya", "IM");
        swimmersServiceImpl.create("seto daiya", "IM");
        verify(swimmersMapper).create(any(Swimmer.class));
    }
}
