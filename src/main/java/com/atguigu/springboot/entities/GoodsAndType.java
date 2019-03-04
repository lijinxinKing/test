package com.atguigu.springboot.entities;

public class GoodsAndType {
    private Integer id;
    private String info;
    private String typename;
    private String estimate;

    public GoodsAndType(Integer id, String info, String typename, String estimate) {
        this.id = id;
        this.info = info;
        this.typename = typename;
        this.estimate = estimate;
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

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }
}
