package com.example.oracle.dao;

import com.example.oracle.vo.EmpVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmpDAO {
    private final JdbcTemplate jdbcTemplate;

    public EmpDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<EmpVO> empSelect() {
        String query = "SELECT * FROM EMP";
        return jdbcTemplate.query(query, new EmpRowMapper());
    }

    public void empInsert() {
        String query = "INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, emp.getEmpNO(), emp.getName(), emp.getJob(), emp.getMgr(), emp.getDate(), emp.getSal(), emp.getComm(), emp.getDeptNO());
    }

    public void empDelete(String name) {
        String query = "DELETE FROM EMP WHERE ENAME = ?";
        jdbcTemplate.update(query, name);
    }

    public void empUpdate(EmpVO emp) {
        String query = "UPDATE EMP SET JOB = ?, SAL = ?, COMM = ? WHERE ENAME = ?";
        jdbcTemplate.update(query, emp.getJob(), emp.getSal(), emp.getComm(), emp.getName());
    }

    public void empSelectRst(List<EmpVO> list) {
        for (EmpVO e : list) {
            System.out.println(e.getEmpNO() + " " + e.getName() + " " + e.getJob() + " " + e.getMgr() + " " + e.getDate() + " " + e.getSal() + " " + e.getComm() + " " + e.getDeptNO());
        }
    }

    private static class EmpRowMapper implements RowMapper<EmpVO> {
        @Override
        public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new EmpVO(
                    rs.getInt("EMPNO"),
                    rs.getString("ENAME"),
                    rs.getString("JOB"),
                    rs.getInt("MGR"),
                    rs.getDate("HIREDATE"),
                    rs.getBigDecimal("SAL"),
                    rs.getBigDecimal("COMM"),
                    rs.getInt("DEPTNO")
            );
        }
    }
}