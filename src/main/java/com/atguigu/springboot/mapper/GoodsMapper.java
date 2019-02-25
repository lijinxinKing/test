package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select *from  goods")
    public List<Goods> GetAllGoods();

}
