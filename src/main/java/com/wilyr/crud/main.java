package com.wilyr.crud;

import com.wilyr.crud.view.postgreSqlView.postgreSqlCommonView;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        postgreSqlCommonView postgreSqlCommonView = new postgreSqlCommonView();
        postgreSqlCommonView.showMainMenu();
    }
}
