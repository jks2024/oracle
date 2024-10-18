package com.example.oracle.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmpVO {
    private int empNO;
    private String name;
    private String job;
    private int mgr;
    private Date date;
    private BigDecimal sal;
    private BigDecimal comm;
    private int deptNO;
}
