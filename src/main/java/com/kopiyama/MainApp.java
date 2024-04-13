package com.kopiyama;

import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.view.MainView;

public class MainApp {
    public static void main(String[] args) {
        RepositoryEmployee.initializeDefaultData();
        MainView mainView = new MainView();

        mainView.displayMenu();
    }
}
