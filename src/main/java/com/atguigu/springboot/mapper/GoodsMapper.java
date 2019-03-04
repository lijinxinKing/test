package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.Goods;
import com.atguigu.springboot.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select *from  goods")
    public List<Goods> GetAllGoods();

    @Insert("insert into goods (info,goodstype,estimate) values (#{info},#{type},#{estimate})")
    @Options(useGeneratedKeys = true,keyProperty = "Id",keyColumn = "id")
    public int InsertGoods(Goods goods);


}
