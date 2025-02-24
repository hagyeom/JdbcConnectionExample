package com.itschool;

import com.itschool.dao.MemberDao;
import com.itschool.entity.Store;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        MemberDao memberDao = new MemberDao();

        System.out.println(memberDao.selectSample("SELECT * FROM public.users"));

        Store store = new Store();

        store.setCompanyName("아이티스쿨");

        System.out.println(store.getCompanyName());

        /*while (true) {
            System.out.println(memberDao.selectSample("SELECT * FROM public.users"));
            Thread.sleep(1000);
        }*/
    }
}
