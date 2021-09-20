package com.example.diceroller.db;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "history")
public class User {

    @PrimaryKey(autoGenerate = true)
    int SlNo;

    public String value;
    private Date date;

    public User(int slNo, String value, Date date) {
        SlNo = slNo;
        this.value = value;
        this.date = date;
    }

    public User(int num, Date date) {
    }

    public void setSlNo(int slNo) {
        SlNo = slNo;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSlNo() {
        return SlNo;
    }

    public String getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }


}
