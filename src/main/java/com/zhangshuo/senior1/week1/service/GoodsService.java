package com.zhangshuo.senior1.week1.service;

import java.util.List;

import com.zhangshuo.senior1.week1.domain.Brand;
import com.zhangshuo.senior1.week1.domain.Goods;
import com.zhangshuo.senior1.week1.domain.GoodsKind;

public interface GoodsService {

	List<Goods> getList(Goods g);

	void add(Goods g);

	List<Brand> getBrand();

	List<GoodsKind> getKind();

	Goods searchById(Integer gid);

	void update(Goods g);

	int deletes(String ids);

}
