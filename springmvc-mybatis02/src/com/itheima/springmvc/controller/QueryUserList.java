package com.itheima.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.ItemService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class QueryUserList {
	@Autowired
	private ItemService itemService;
	public List<Items> itemList(){
		//从Mysql中查询
		List<Items> list = itemService.selectItemsList();
		return list;
	}
	
}
