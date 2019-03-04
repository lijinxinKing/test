package com.atguigu.springboot.service;

import com.atguigu.springboot.entities.Goods;
import com.atguigu.springboot.entities.GoodsAndType;
import com.atguigu.springboot.mapper.GoodsAndTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsAndTypeService {

    @Autowired
    GoodsAndTypeMapper goodsAndTypeMapper;

    public List<GoodsAndType> GetAllGoodsOfTypeName(){

        List<GoodsAndType> allGoods = goodsAndTypeMapper.GetAllGoodsAndType();
        return allGoods;

    }


}
