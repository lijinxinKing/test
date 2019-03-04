package com.atguigu.springboot.entities;

import com.atguigu.springboot.service.GoodstypeService;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.Serializable;

public class Goods {
    private Integer id;
    private String info;
    private Integer type;

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private String typeName;
    private String estimate;

    public Goods(String info, Integer type, String estimate) {
        this.info = info;
        this.type = type;
        this.estimate = estimate;
    }

    public Goods(Integer id, String info,String typeName, String estimate) {
        this.id = id;
        this.info = info;
        this.typeName = typeName;
        this.estimate = estimate;
    }

    public Goods(Integer id, String info, Integer type, String estimate) {
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

    public Integer getType() {
        return type;
    }

    public String getTypeName(){
        Integer id = this.getId();
        GoodstypeService goodstypeService = new GoodstypeService();
        String typeName = goodstypeService.GetTypeName(id);
        return typeName;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }
}
