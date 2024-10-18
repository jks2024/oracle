package com.example.oracle;

import com.example.oracle.dao.EmpDAO;
import com.example.oracle.vo.EmpVO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class OracleApplication implements CommandLineRunner {

    private final EmpDAO empDAO;

    public OracleApplication(EmpDAO empDAO) {
        this.empDAO = empDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(OracleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menuSelect();
    }

    public void menuSelect() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== EMP 테이블 조회 =====");
            System.out.println("메뉴를 선택 하세요 : ");
            System.out.println("[1]SELECT, [2]INSERT, [3]UPDATE, [4]DELETE, [5]EXIT");
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    List<EmpVO> list = empDAO.empSelect();
                    empDAO.empSelectRst(list);
                    break;
                case 2:
                    empDAO.empInsert();
                    break;

            }
        }
    }
}
