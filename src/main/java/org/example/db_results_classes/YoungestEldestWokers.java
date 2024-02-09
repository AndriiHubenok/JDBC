package org.example.db_results_classes;

import java.util.Date;

public class YoungestEldestWokers {
    private String type;
    private String name;
    private Date birthday;

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
