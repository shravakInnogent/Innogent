package com.company;

import java.io.Serializable;

public class Class  implements Serializable {
    int id;
    String cls ;
    public String toString(){
        return "Class\n" + cls ;
    }
    public int getId() {
        return id;
    }

    public String getCls() {
        return cls;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

}