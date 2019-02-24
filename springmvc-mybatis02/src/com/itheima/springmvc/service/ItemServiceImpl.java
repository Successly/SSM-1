package com.itheima.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;

/**
 * 查询商品信息
 * @author lx
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	//查询商品列表
	public List<Items> selectItemsList(){
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	public Items selectItemsById(Integer id){
		return itemsMapper.selectByPrimaryKey(id);
	}
	//修改
	public void updateItemsById(Items items){
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
	
	
	//新增2019-02-24
	public void insertItems(Items items) {
		// TODO Auto-generated method stub
	
		int a1=itemsMapper.insertItems(items);
		System.out.println("新增a1");
		System.out.println(a1);
		/*itemsMapper.insert(items);*/
	}
	
	//修改
	public void updatetItems(Items items) {
		
		int a=itemsMapper.updateItems(items);
		System.out.println("xiugai");
		System.out.println(a);
	}
	//删除 deleteByItemsId
	public void deleteByItemsId(int id) {
		
		int deleteId=itemsMapper.deleteByItemsId(id);
		System.out.println("deleteId");
		System.out.println(deleteId);
	}
}
