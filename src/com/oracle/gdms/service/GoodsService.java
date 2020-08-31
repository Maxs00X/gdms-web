package com.oracle.gdms.service;

import java.util.List;
import java.util.Map;

import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.PageModel;

public interface GoodsService {

	/**
	 * 分页显示商品数据
	 * @param pageNumber 当前页码
	 * @param rows 每页多少条记录
	 * @return 
	 */
	PageModel<GoodsModel> findByPage(int pageNumber, int rows);

	
	/**
	 * 推送指定ID的商品
	 * @param goodsid
	 * @return 成功消息为空串，失败为消息内容
	 */
	String pushGoods(int goodsid);


	/**
	 * 增加一条商品记录
	 * @param goods
	 * @return 受影响的行数
	 */
	int add(GoodsEntity goods);


	/**
	 * 根据关键词搜索商品记录，分页显示
	 * @param kw 关键词
	 * @param p 页码
	 * @param rows 每页行数
	 * @return
	 */
	PageModel<GoodsModel> findByKeywords(String kw, int p, int rows);


	/**
	 * 查询数据进行导出成Excel下载
	 * @param kw
	 * @return
	 */
	List<GoodsModel> findByKeywords(String kw);

	
	/**
	 * 删除一组商品数据（更新状态）
	 * @param gid
	 */
	void delete(String[] gid);

	/**
	 * 更新一组商品数据，并返回受影响行数
	 * @param goods
	 * @return 受影响的行数
	 */
	int update(GoodsEntity goods);

	/**
	 * 根据商品id，返回一个商品对象
	 * @param goodsid
	 * @return GoodsModel
	 */
	GoodsModel findOne(int goodsid);

	/**
	 * 根据商品分类，返回一组商品对象（多表
	 * @param params
	 * @return
	 */
	List<GoodsModel> findByDesc(String[] params);

	/**
	 * 根据类别ID查询所有商品
	 * @param gtid
	 * @return List<GoodsModel>
	 */
	List<GoodsModel> findByType(int gtid);
}
