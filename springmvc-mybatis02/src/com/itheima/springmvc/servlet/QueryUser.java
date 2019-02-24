package com.itheima.springmvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.itheima.springmvc.controller.ItemController;
import com.itheima.springmvc.controller.QueryUserList;
import com.itheima.springmvc.controller.SaveItems;
import com.itheima.springmvc.pojo.Items;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class QueryUser
 */
public class QueryUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private QueryUserList queryUserList;
    private ItemController itemController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*request.setCharacterEncoding("UTF-8");*/

		
		String s;
		s="12312312";
		ServletContext servletContext = this .getServletContext(); 
		
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		
/*		queryUserList= (QueryUserList)ctx.getBean("queryUserList" );
		System.out.println(queryUserList);
		List<Items> list =queryUserList.itemList();
	
		
//	    System.out.println(gson.toJson(queryUserList));
		System.out.println(queryUserList);
		
		 
//		 queryUserList.itemList(request, response);
		JSONObject jsonObject = new JSONObject();
		
		 JSONArray jsonArray = new JSONArray();
		jsonObject.put("name", "John");
		jsonObject.put("sex", "male");
		jsonObject.put("age", 22);
	
		
		System.out.println(jsonObject);
	    Gson gson =new Gson();
		
//	    System.out.println(gson.toJson(queryUserList));
		for(Items item : list){
			gson.toJson(item);
//			System.out.println(gson.toJson(item));
		
			jsonArray.add(gson.toJson(item));
		}
		jsonObject.put("array", jsonArray);
		
		System.out.println(jsonObject);
		 
		 PrintWriter out=response.getWriter(); 
		out.write(jsonObject.toString());
		request.setCharacterEncoding("UTF-8");
		//Get 带参数
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		
		System.out.println(name);
		System.out.println(sex);
		System.out.println(age);*/
		
		//新增
/*		SaveItems saveItems=(SaveItems)ctx.getBean("saveItems" );
//		id, name, price, 
//	      pic, createtime, detail
		Items items =new Items();
//		items.setId(16);
		items.setName("快快快");
		items.setPrice(3333.0008f);
		items.setPic("rttttt");
		items.setCreatetime(new Date());
		items.setDetail("maskdoasodoas你你你申冬奥");
		
		saveItems.insertItems(items);
		System.out.println("itemsgetId");
		System.out.println(items.getId());*/
		
		//修改
	/*	SaveItems updateItems =(SaveItems) ctx.getBean("saveItems");
		
		Items items = new Items ();
		items.setId(7);
		items.setName("我是个新的");
		items.setPrice(99.08f);
		items.setPic("44444444444444");
		items.setCreatetime(new Date());
		updateItems.updatetItems(items);
		System.out.println("updateItems");
		System.out.println(items.getId());*/
	
		//删除
		SaveItems saveItems=(SaveItems)ctx.getBean("saveItems" );
		saveItems.deleteByItemsId(9);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		
		System.out.println(name);
		System.out.println(sex);
		System.out.println(age);
/*		doGet(request, response);*/
	}

}
