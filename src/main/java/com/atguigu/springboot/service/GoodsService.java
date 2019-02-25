package com.atguigu.springboot.service;

import com.atguigu.springboot.entities.Goods;
import com.atguigu.springboot.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    public List<Goods>GetAllGoods(){
        List<Goods> allGoods = new ArrayList<>();
        allGoods = goodsMapper.GetAllGoods();
        return allGoods;
    }
}
