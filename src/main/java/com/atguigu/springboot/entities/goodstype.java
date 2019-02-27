package com.atguigu.springboot.entities;

public class goodstype {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public goodstype(Integer id, String goodstype) {
        this.id = id;
        this.goodstype = goodstype;
    }

    @Override
    public String toString() {
        return "goodstype{" +
                "id=" + id +
                ", goodstype='" + goodstype + '\'' +
                '}';
    }

    public goodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    private String goodstype;

}
