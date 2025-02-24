package com.itschool.dao;

import com.itschool.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao extends DataAccessObject {
    public List<User> selectSample(String sql) throws SQLException {
        List<User> resultList = new ArrayList<>();

        // try-with-resource 문

        try (Connection dbConn = connect(); // 연결 생성
             Statement st = dbConn.createStatement(); // pgAdmin QueryTool
             ResultSet rs = st.executeQuery(sql)) { // 쿼리 실행 후 결과 ResultSet에 저장

            while (rs.next()) { // 다음이 존재할 경우 (전체 순환)
                String id = rs.getString("id");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phone_number");

                // 자바 객체 매핑
                User user = new User(Integer.parseInt(id), name, phoneNumber);

                resultList.add(user);
            }

        } catch (SQLException e) {
            throw e;
        }

        return resultList;
    }
}
