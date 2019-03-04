package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.GoodsAndType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsAndTypeMapper {
    @Select("select g.id, g.info, t.goodstype, g.estimate FROM goods g , goods_type t where (t.id = g.goodstype)")
    public List<GoodsAndType> GetAllGoodsAndType();
}
