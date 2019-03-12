package com.atguigu.springboot.service;

import com.atguigu.springboot.entities.goodstype;
import com.atguigu.springboot.mapper.GoodstypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodstypeService {

    @Autowired
    GoodstypeMapper goodstypeMapper;

    public List<goodstype> GetAllGoodsType(){
        List<goodstype> allGoodsType = goodstypeMapper.GetAllGoodsType();
        return allGoodsType;
    }


    public void AddNewGoodstype(String goodsType){
        goodstype goodstype =  new goodstype(goodsType);
        goodstypeMapper.InsertGoodstype(goodstype);
    }

    public void DeleteGoodsType(String id){
        int result = goodstypeMapper.DeleteGoodsType(id);
        if(result == 1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }

    }

    public String GetTypeName(Integer id){
        goodstype goodstype =  goodstypeMapper.GetGoodsTypeById(id);
        return goodstype.getGoodstype();
    }
}
