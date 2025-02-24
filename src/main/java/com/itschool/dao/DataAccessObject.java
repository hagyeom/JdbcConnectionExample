package com.itschool.dao;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DAO, Data Access Object, 데이터 접근을 위한 객체
public abstract class DataAccessObject {

    HikariDataSource ds = new HikariDataSource();

    // final static private String DB_DRIVER = "org.postgresql.Driver";
    final static private String DB_URL = "jdbc:postgresql://database-1.cha0wwwcav3v.ap-northeast-2.rds.amazonaws.com:5432/postgres";
    final static private String DB_USER = "postgres";
    final static private String DB_PASSWORD = "12345678";

    // 초기화 블록
    {
        ds.setJdbcUrl(DB_URL);
        ds.setUsername(DB_USER);
        ds.setPassword(DB_PASSWORD);
    }

    // 1. Connection 모듈화 (DB 연결)
    protected Connection connect() {
        // region DB 드라이버 불러오기 (Java 6 이상부터는 작성하지 않아도 자동 로드)
        /*try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Database driver loading failed");
        }*/
        // endregion

        // JDBC 드라이버 매니저를 이용해서 연결
        // JDBC: 자바에서 데이터베이스 접속할 수 있도록 하는 자바 API
        try {
            // Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Connection connection = ds.getConnection();
            System.out.println("DB Connection [성공]");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("데이터 베이스 연결에 실패했습니다.", e);
        }
    }
}
