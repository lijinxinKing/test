package com.atguigu.springboot.entities;

import java.io.Serializable;

public class Goods {
    private Integer id;
    private String info;
    private String type;
    private String estimate;

    public Goods(String info, String type, String estimate) {
        this.info = info;
        this.type = type;
        this.estimate = estimate;
    }

    public Goods(Integer id, String info, String type, String estimate) {
        this.id = id;
        this.info = info;
        this.type = type;
        this.estimate = estimate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "info='" + info + '\'' +
                ", type='" + type + '\'' +
                ", estimate='" + estimate + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }
}
