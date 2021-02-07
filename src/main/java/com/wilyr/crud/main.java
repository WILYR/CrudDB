package com.wilyr.crud;

import com.wilyr.crud.view.HibernateView.CommonView;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        CommonView CommonView = new CommonView();
        CommonView.showMainMenu();
    }
}
