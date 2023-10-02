package com.example.final_task.service;

import com.example.final_task.entity.Swimmer;
import com.example.final_task.mapper.SwimmersMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SwimmersServiceImplTest {
    @InjectMocks
    SwimmersServiceImpl swimmersServicelmpl;

    @Mock
    SwimmersMapper swimmersMapper;

    @Test
    public void 存在する水泳選手がすべて取得できること() {
        List<Swimmer> swimmerList = List.of(
                new Swimmer("meboso kodai", "breaststroke"),
                new Swimmer("ikee rikkako", "butterfly"),
                new Swimmer("irie ryosuke", "backstroke")
                );
        doReturn(swimmerList).when(swimmersMapper).findAll();
        //テスト対象メソッドの呼び出し
        List<Swimmer> actual = swimmersServicelmpl.findAll();
        assertThat(actual).isEqualTo(swimmerList);
        verify(swimmersMapper, times(1)).findAll();
    }

}
