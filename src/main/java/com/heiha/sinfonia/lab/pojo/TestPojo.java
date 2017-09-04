package com.heiha.sinfonia.lab.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/9/4 10:33<br>
 * <b>Author:</b> heiha<br>
 */
@Data
@Builder
public class TestPojo implements Serializable {
    public static final String test = "test";
    public static final long serialVersionUID = 1L;
    private transient String test1;
    private Integer test2;
    private List<String> test3;
    private int test4;
    private transient int test5;
}
