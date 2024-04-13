package com.kopiyama;

import com.kopiyama.view.MainView;
import com.kopiyama.view.print.PrintDisplay;

public class MainApp {
    public static void main(String[] args) {
        PrintDisplay printDisplay = new PrintDisplay();
        MainView mainView = new MainView();

        mainView.displayMenu();
    }
}
