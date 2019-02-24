package com.itheima.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.ItemService;

@Controller
public class SaveItems {
	@Autowired
	private ItemService itemService;
	public void insertItems(Items items){

		//从Mysql中查询
		itemService.insertItems(items);
		
		return;
	}
	public void updatetItems(Items items){

		//从Mysql中查询
		itemService.updatetItems(items);
		
		return;
	}
	
	public void deleteByItemsId(int id){

		//从Mysql中查询
		itemService.deleteByItemsId(id);
		
		return;
	}
}
