package com.zhangshuo.senior1.week1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhangshuo.senior1.week1.domain.Brand;
import com.zhangshuo.senior1.week1.domain.Goods;
import com.zhangshuo.senior1.week1.domain.GoodsKind;

public interface GoodsDao {

	List<Goods> getList(Goods g);

	void add(Goods g);

	@Select("select * from tb_brand")
	List<Brand> getBrand();

	@Select("select * from tb_goodskind")
	List<GoodsKind> getKind();

	@Select("select * from tb_goods where gid=#{gid}")
	Goods searchById(@Param("gid")Integer gid);

	void update(Goods g);

	@Delete("delete from tb_goods where gid in (${ids})")
	int deletes(@Param("ids")String ids);

}
