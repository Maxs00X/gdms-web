package com.oracle.gdms.service;

import java.util.List;
import java.util.Map;

import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.PageModel;

public interface GoodsService {

	/**
	 * ��ҳ��ʾ��Ʒ����
	 * @param pageNumber ��ǰҳ��
	 * @param rows ÿҳ��������¼
	 * @return 
	 */
	PageModel<GoodsModel> findByPage(int pageNumber, int rows);

	
	/**
	 * ����ָ��ID����Ʒ
	 * @param goodsid
	 * @return �ɹ���ϢΪ�մ���ʧ��Ϊ��Ϣ����
	 */
	String pushGoods(int goodsid);


	/**
	 * ����һ����Ʒ��¼
	 * @param goods
	 * @return ��Ӱ�������
	 */
	int add(GoodsEntity goods);


	/**
	 * ���ݹؼ���������Ʒ��¼����ҳ��ʾ
	 * @param kw �ؼ���
	 * @param p ҳ��
	 * @param rows ÿҳ����
	 * @return
	 */
	PageModel<GoodsModel> findByKeywords(String kw, int p, int rows);


	/**
	 * ��ѯ���ݽ��е�����Excel����
	 * @param kw
	 * @return
	 */
	List<GoodsModel> findByKeywords(String kw);

	
	/**
	 * ɾ��һ����Ʒ���ݣ�����״̬��
	 * @param gid
	 */
	void delete(String[] gid);

	/**
	 * ����һ����Ʒ���ݣ���������Ӱ������
	 * @param goods
	 * @return ��Ӱ�������
	 */
	int update(GoodsEntity goods);

	/**
	 * ������Ʒid������һ����Ʒ����
	 * @param goodsid
	 * @return GoodsModel
	 */
	GoodsModel findOne(int goodsid);

	/**
	 * ������Ʒ���࣬����һ����Ʒ���󣨶��
	 * @param params
	 * @return
	 */
	List<GoodsModel> findByDesc(String[] params);

	/**
	 * �������ID��ѯ������Ʒ
	 * @param gtid
	 * @return List<GoodsModel>
	 */
	List<GoodsModel> findByType(int gtid);
}