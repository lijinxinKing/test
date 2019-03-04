package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.Goods;
import com.atguigu.springboot.entities.goodstype;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodstypeMapper {

    @Select("select *from goods_type")
    public List<goodstype> GetAllGoodsType();

    @Delete("Delete from goods_type where id=#{id}")
    public Void DeleteGoodsType(Integer id);

    @Select("select *from goods_type where id = #{id}")
    public goodstype GetGoodsTypeById(Integer id);


    @Insert("insert into goods_type (goodstype) values (#{goodstype})")
    @Options(useGeneratedKeys = true,keyProperty = "Id",keyColumn = "id")
    public int InsertGoodstype(goodstype goodstype);


}
