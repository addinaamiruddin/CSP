//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.csp;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Scholarship {
    private String status;
    private String name;
    private String types;
    private String level;

    public Scholarship(String status, String name, String types, String level) {
        this.status = status;
        this.name = name;
        this.types = types;
        this.level = level;
    }

    public String getStatus() {
        return this.status;
    }

    public String getName() {
        return this.name;
    }

    public String getTypes() {
        return this.types;
    }

    public String getLevel() {
        return this.level;
    }

}

