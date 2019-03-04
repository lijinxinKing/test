package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.Goods;
import com.atguigu.springboot.entities.GoodsAndType;
import com.atguigu.springboot.entities.goodstype;
import com.atguigu.springboot.service.GoodsService;
import com.atguigu.springboot.service.GoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.atguigu.springboot.service.GoodsAndTypeService;

import java.util.Collection;
import java.util.List;

@Controller
public class goodscontrller {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodstypeService goodstypeService;

    @Autowired
    GoodsAndTypeService goodstAndTypeService;

    @GetMapping("/goodslist")
    public String goodsList(Model model){
        Collection<GoodsAndType> goodsList = goodstAndTypeService.GetAllGoodsOfTypeName();
        model.addAttribute("allgoods", goodsList);
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
        return "goods/add";

    }

    @PostMapping("/addnewgoods")
    public String AddGoods(@RequestParam("info") String info, @RequestParam("id") Integer goodsType,
                           @RequestParam("estimate") String estimate,Model model){


        List<goodstype> allGoodstype = goodstypeService.GetAllGoodsType();
        model.addAttribute("allgoodstype",  allGoodstype);

        Goods goods = new Goods(info, goodsType, estimate);

        goodsService.AddGoods(goods);
        return "redirect:/goodslist";

    }

    ///////////////////////////商品类型管理 包括添加 和删除 商品 类型/////////////////////////////////////////////////
    @GetMapping("goodstype")
    public String GoodsTypeManager(Model model){
        List<goodstype> allGoodsType = goodstypeService.GetAllGoodsType();
        model.addAttribute("allgoodstype",allGoodsType);
        return "goods/types";
    }

    @GetMapping("goodstypemanager")
    public String DeleteGoodsType(@RequestParam("goodstype")Integer id){
        Integer index = id;//Integer.parseInt(id);
        goodstypeService.DeleteGoodsType(index);
        return "redirect:goods/types";

    }

    @PostMapping("goodstypemanager")
    public String AddGoodsType(@RequestParam("goodstype") String goodstype,Model model){

        goodstypeService.AddNewGoodstype(goodstype);
        List<goodstype> allGoodsType = goodstypeService.GetAllGoodsType();
        model.addAttribute("allgoodstype",allGoodsType);

        return "goods/types";
    }

}
