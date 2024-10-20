package com.example.oracle;

import com.example.oracle.dao.EmpDAO;
import com.example.oracle.vo.EmpVO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class OracleApplication implements CommandLineRunner {

    private final EmpDAO dao;

    public OracleApplication(EmpDAO dao) {
        this.dao = dao;
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
                    List<EmpVO> list = dao.empSelect();
                    dao.empSelectRst(list);
                    break;
                case 2:
                    empInsert(sc);
                    break;
                case 3:
                    empUpdate(sc);
                    break;
                case 4:
                    empDelete(sc);
                    break;
                case 5:
                    System.out.println("메뉴를 종료 합니다");
                    return;
            }
        }
    }
    public void empInsert(Scanner sc) {
        System.out.println("사원 정보를 입력 하세요.");
        System.out.print("사원번호(4자리) : ");
        int no = sc.nextInt();
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("직책 : ");
        String job = sc.next();
        System.out.print("상관 사원 번호 : ");
        int mgr = sc.nextInt();
        System.out.print("입사일 : ");
        String date = sc.next();
        System.out.print("급여 : ");
        BigDecimal sal = sc.nextBigDecimal();
        System.out.print("성과급 : ");
        BigDecimal comm = sc.nextBigDecimal();
        System.out.print("부서번호 : ");
        int dept = sc.nextInt();

        EmpVO emp = new EmpVO(no, name, job, mgr, Date.valueOf(date), sal, comm, dept);
        dao.empInsert(emp);
    }

    public void empUpdate(Scanner sc) {
        System.out.print("변경할 사원의 이름을 입력 하세요 : ");
        String name = sc.next();
        System.out.print("직책 : ");
        String job = sc.next();
        System.out.print("급여 : ");
        BigDecimal sal = sc.nextBigDecimal();
        System.out.print("성과급 : ");
        BigDecimal comm = sc.nextBigDecimal();

        EmpVO emp = new EmpVO();
        emp.setName(name);
        emp.setJob(job);
        emp.setSal(sal);
        emp.setComm(comm);

        dao.empUpdate(emp);
    }

    public void empDelete(Scanner sc) {
        System.out.print("삭제할 이름을 입력 하세요 : ");
        String name = sc.next();
        dao.empDelete(name);
    }
}
