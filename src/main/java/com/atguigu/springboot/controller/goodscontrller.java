package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.Goods;
import com.atguigu.springboot.entities.goodstype;
import com.atguigu.springboot.service.GoodsService;
import com.atguigu.springboot.service.GoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Collection;
import java.util.List;

@Controller
public class goodscontrller {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodstypeService goodstypeService;

    @GetMapping("/goodslist")
    public String goodsList(Model model){
        Collection<Goods> goodsList = goodsService.GetAllGoods();
        model.addAttribute("allgoods",goodsList);
        return "/goods/list";
    }

    @GetMapping("/about")
    public String aboutGoods(){
        return "/goods/about";
    }

    @GetMapping("/addgoods")
    public String addGoods(Model model){

        List<goodstype> allGoodsType = goodstypeService.GetAllGoodsType();
        model.addAttribute("allgoodstype",allGoodsType);
        return "/goods/add";

    }

    @PostMapping("/addnewgoods")
    public String AddGoods(@RequestParam("info") String info, @RequestParam("goodstype") String goodsType,
                           @RequestParam("estimate") String estimate){
        Goods goods = new Goods(info, goodsType, estimate);
        goodsService.AddGoods(goods);
        return "redirect:/goodslist";
    }

    ///////////////////////////商品类型管理 包括添加 和删除 商品 类型/////////////////////////////////////////////////
    @GetMapping("goodstype")
    public String GoodsTypeManager(Model model){
        List<goodstype> allGoodsType = goodstypeService.GetAllGoodsType();
        model.addAttribute("allgoodstype",allGoodsType);
        return "/goods/types";
    }

    @PostMapping("goodstypemanager")
    public String AddGoodsType(@RequestParam("goodstype") String goodstype,Model model){

        goodstypeService.AddNewGoodstype(goodstype);
        List<goodstype> allGoodsType = goodstypeService.GetAllGoodsType();
        model.addAttribute("allgoodstype",allGoodsType);

        return "/goods/types";
    }

}
