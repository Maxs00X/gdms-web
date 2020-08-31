package com.oracle.gdms.dao;

import com.oracle.gdms.entity.GoodsType;

import java.util.List;
import java.util.Map;

public interface GoodsTypeDao {
	
	int add(GoodsType obj);
	
	GoodsType findById(int gtid);

	//List<Integer> findByDesc(Map<String,Object> map);
	
}
