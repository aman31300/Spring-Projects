package com.example.crudapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int pid;
    private String pName;
    private String pDescription;
    private int pPrice;

    @Override
    public String toString() {
        return "products{" +
                "pid=" + pid +
                ", pName='" + pName + '\'' +
                ", pDescription='" + pDescription + '\'' +
                ", pPrice=" + pPrice +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public products() {
    }

    public products(int pid, String pName, String pDescription, int pPrice) {
        this.pid = pid;
        this.pName = pName;
        this.pDescription = pDescription;
        this.pPrice = pPrice;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }
}
