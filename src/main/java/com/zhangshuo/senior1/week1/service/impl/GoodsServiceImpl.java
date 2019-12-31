package com.zhangshuo.senior1.week1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangshuo.senior1.week1.dao.GoodsDao;
import com.zhangshuo.senior1.week1.domain.Brand;
import com.zhangshuo.senior1.week1.domain.Goods;
import com.zhangshuo.senior1.week1.domain.GoodsKind;
import com.zhangshuo.senior1.week1.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDao dao;
	public List<Goods> getList(Goods g) {
		return dao.getList(g);
	}
	public void add(Goods g) {
		dao.add(g);
	}
	public List<Brand> getBrand() {
		return dao. getBrand();
	}
	public List<GoodsKind> getKind() {
		return dao.getKind();
	}
	public Goods searchById(Integer gid) {
		return dao.searchById(gid);
	}
	public void update(Goods g) {
		dao.update(g);
	}
	public int deletes(String ids) {
		return dao.deletes(ids);
	}

}
