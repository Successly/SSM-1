package com.itheima.springmvc.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingFilter implements Filter{

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		
		response.setCharacterEncoding("UTF-8");   

		response.setContentType("text/html;charset=UTF-8");
		//request.setCharacterEncoding("UTF-8");
		
		//在传递request之前对request的getParameter方法进行增强
		/*
		 * 装饰者模式(包装)
		 * 
		 * 1、增强类与被增强的类要实现统一接口
		 * 2、在增强类中传入被增强的类
		 * 3、需要增强的方法重写 不需要增强的方法调用被增强对象的
		 * 
		 */
		 String method = ((HttpServletRequest) request).getMethod();//得到请求URL地址时使用的方法
	 System.out.println(method);
		 if(method=="GET"){
			 //被增强的对象
			HttpServletRequest req = (HttpServletRequest) request;
			//增强对象
			EnhanceRequest enhanceRequest = new EnhanceRequest(req);
			
			chain.doFilter(enhanceRequest, response);
		}else{
			request.setCharacterEncoding("UTF-8");
			chain.doFilter(request, response);
		}
		
		
	}


	public void destroy() {
		
	}
	
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
class EnhanceRequest extends HttpServletRequestWrapper{
	
	private HttpServletRequest request;

	public EnhanceRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	//对getParaameter增强
	@Override
	public String getParameter(String name) {
		String parameter = request.getParameter(name);//乱码
		try {
			parameter = new String(parameter.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return parameter;
	}
	
}
