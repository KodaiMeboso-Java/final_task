package com.example.final_task.service;

import com.example.final_task.entity.Swimmer;
import com.example.final_task.mapper.SwimmersMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        assertThat(actual).isEqualTo(new Swimmer(1,"meboso","breaststroke"));
        verify(swimmersMapper,times(1)).findById(1);
    }
}
