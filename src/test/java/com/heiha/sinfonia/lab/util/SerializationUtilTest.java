package com.heiha.sinfonia.lab.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiha.sinfonia.lab.pojo.TestPojo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/4 10:43<br>
 * <b>Author:</b> heiha<br>
 */
public class SerializationUtilTest {
    @Test
    public void test() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String path = "logs/test.obj";
        List<String> list = new ArrayList<>();
        list.add("Hello World");
        list.add("Ni hao");
        TestPojo test = TestPojo.builder().test1("test1").test2(2).test3(list)
                .test4(4)
                .test5(5)
                .build();
        SerializationUtil.serialize(test, path);
        System.out.println(objectMapper.writeValueAsString(SerializationUtil.deserialize(path)));
    }
}