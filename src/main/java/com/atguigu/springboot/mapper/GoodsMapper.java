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

    @Select("select *from  goods where estimate like '%好%' and estimate not like '%不好%' ")
    public List<Goods> GetAllGoodBack();

    @Select("select *from  goods where estimate like '%不好%' or estimate like '%差%' ")
    public List<Goods> GetAllFeedBack();

    @Select("select *from goods where id=#{id}")
    public Goods GetGoodsById(Long id);

}
