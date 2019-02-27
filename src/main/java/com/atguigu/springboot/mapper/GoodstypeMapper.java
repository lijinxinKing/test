package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.Goods;
import com.atguigu.springboot.entities.goodstype;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodstypeMapper {

    @Select("select *from goods_type")
    public List<goodstype> GetAllGoodsType();


    @Insert("insert into goods_type (goodstype) values (#{goodstype})")
    @Options(useGeneratedKeys = true,keyProperty = "Id",keyColumn = "id")
    public int InsertGoodstype(goodstype goodstype);


}
