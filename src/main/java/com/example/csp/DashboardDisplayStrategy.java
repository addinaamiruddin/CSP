package com.example.csp;

// implement Interface Segregation Principle (ISP) as both dashboard implement the method.
// POLYMORPHISM is implemented which admin and student have a different implementation of the same method.

import javafx.event.ActionEvent;

public interface DashboardDisplayStrategy {
//    void displayUserPortal();

    void displayUserLogin(ActionEvent event);

    void displayUserRegister(ActionEvent event);

    void displayUserPortal(ActionEvent event);
}