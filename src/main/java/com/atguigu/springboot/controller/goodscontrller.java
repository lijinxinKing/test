package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.Goods;
import com.atguigu.springboot.entities.GoodsAndType;
import com.atguigu.springboot.entities.goodstype;
import com.atguigu.springboot.service.GoodsService;
import com.atguigu.springboot.service.GoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/goodsestimate")
    public String GoodsEstimateManager(){
        System.out.println("Test Goods Estimate");
        return "goods/goodsestimate";
    }

    @GetMapping("/goodsupdate")
    public String GoodsUpdate(Model model){
        System.out.println("Test Goods GoodsUpdate");
        Collection<GoodsAndType> goodsList = goodstAndTypeService.GetAllGoodsOfTypeName();
        model.addAttribute("allgoods", goodsList);
        return "goods/updatelist";
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

    @GetMapping("listfeedback")
    public String listfeedback(Model model){
        List<Goods> goodback = goodsService.ListFeedBack();
        model.addAttribute("feedback", goodback);
        System.out.println("列出差评" + goodback);
        return "goods/listfeedback";
    }

    @GetMapping("listgoodback")
    public String listgoodsback(Model model){
        List<Goods> goodback = goodsService.ListGoodBack();
        model.addAttribute("goodback", goodback);
        System.out.println("列出好评" + goodback);
        return "goods/listgoodback";
    }

    @GetMapping("/delete/{id}")
    public String DeleteGoodsType(@PathVariable("id") Long id){
        goodstypeService.DeleteGoodsType(id);
        return "redirect:/goodstype";
    }

    @GetMapping("/update/{id}")
    public String UpdateGoods(@PathVariable("id") Long id, Model model){
        Goods updateGoods = goodsService.GetGoodsById(id);
        model.addAttribute("updategoods", updateGoods);
        System.out.println("Update Goods:"  + updateGoods);
        return "goods/list";
    }

    @PostMapping("goodstypemanager")
    public String AddGoodsType(@RequestParam("goodstype") String goodstype,Model model){
        goodstypeService.AddNewGoodstype(goodstype);
        List<goodstype> allGoodsType = goodstypeService.GetAllGoodsType();
        model.addAttribute("allgoodstype",allGoodsType);
        return "goods/types";
    }

}
