package com.zhangshuo.senior1.week1.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangshuo.senior1.week1.domain.Brand;
import com.zhangshuo.senior1.week1.domain.Goods;
import com.zhangshuo.senior1.week1.domain.GoodsKind;
import com.zhangshuo.senior1.week1.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService service;
	//列表
	@RequestMapping("list")
	public String getList(@RequestParam(defaultValue = "1")Integer pageNum,Model m,Goods g) {
		PageHelper.startPage(pageNum, 3);
		List<Goods> list = service.getList(g);
		PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
		m.addAttribute("list", list);
		m.addAttribute("pg", pageInfo);
		m.addAttribute("g", g);
		return "list";
	}
	//添加
	@RequestMapping("toAdd")
	public String toAdd(Model m) {
		m.addAttribute("g", new Goods());
		return "add";
	}
	@RequestMapping("add")
	public String add(@ModelAttribute Goods g,@RequestParam("file")MultipartFile file,Model m) throws IllegalStateException, IOException {
		if(file != null && !file.isEmpty()) {
			String path = "D:\\img";
			File file2 = new File(path+file.getOriginalFilename());
			file2.mkdirs();
			file.transferTo(file2);
			g.setImage(file.getOriginalFilename());
			service.add(g);
		}
		m.addAttribute("success", "添加成功");
		return "redirect:list";
	}
	//下拉菜单
	@RequestMapping("getBrand")
	@ResponseBody
	public List<Brand> getBrand(){
		return service.getBrand();
	}
	@RequestMapping("getKind")
	@ResponseBody
	public List<GoodsKind> getKind(){
		return service.getKind();
	}
	
	
	
	//修改
	/*
	 * @RequestMapping("toUpdate") public String toUpdate(Model m) {
	 * m.addAttribute("g", new Goods()); return "update"; }
	 */
	@RequestMapping("update")
	public String update(@ModelAttribute Goods g,@RequestParam("file")MultipartFile file,Model m) throws IllegalStateException, IOException {
		if(file != null && !file.isEmpty()) {
			String path = "D:\\img";
			File file2 = new File(path+file.getOriginalFilename());
			file2.mkdirs();
			file.transferTo(file2);
			g.setImage(file.getOriginalFilename());
			service.update(g);
		}
		return "redirect:list";
	}
	//回显
	@RequestMapping("searchById")
	public String searchById(Integer gid,Model m) {
		Goods goods = service.searchById(gid);
		m.addAttribute("goods", goods);
		 m.addAttribute("g", new Goods());
		return "update";
	}
	//删除
	@RequestMapping("deletes")
	@ResponseBody
	public int deletes(String ids) {
		int i = service.deletes(ids);
		return i;
	}
}
