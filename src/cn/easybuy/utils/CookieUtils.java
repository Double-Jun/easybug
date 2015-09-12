package cn.easybuy.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 * 
 * @author mingjun chen
 *
 */
public class CookieUtils {

	/** cookie中商品数量-1 */
	public static void reduce(int id, HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();// 获取一个cookie数组
		boolean bool = false;
		for (Cookie cookie : cookies) { // 遍历这个cookie数组
			System.out.println("这是每一次cookie：" + cookie.getName() + ":"
					+ cookie.getValue());
			if (cookie.getName().equals(String.valueOf(id))
					&& Integer.parseInt(cookie.getValue()) > 1) { // 根据商品id匹配cookie,如果匹配到了则修改他
				int num = Integer.parseInt(cookie.getValue()) - 1; // 得到cookie中商品数量，然后加一
				CookieUtils.addCookie(id, num, request, response); // 重新写回cookie
				bool = true;
			}
		}
		// 如果没有找到对应的cookie值，则创建他，让他该商品数量为1
		if (!bool) {
			CookieUtils.addCookie(id, 1, request, response);
		}
	}

	/** cookie中商品数量+1 */
	public static void plus(int id, HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();// 获取一个cookie数组
		boolean bool = false;
		for (Cookie cookie : cookies) { // 遍历这个cookie数组
			System.out.println("这是每一次cookie：" + cookie.getName() + ":"
					+ cookie.getValue());
			if (cookie.getName().equals(String.valueOf(id))) { // 根据商品id匹配cookie,如果匹配到了则修改他
				int num = Integer.parseInt(cookie.getValue()) + 1; // 得到cookie中商品数量，然后加一
				CookieUtils.addCookie(id, num, request, response); // 重新写回cookie
				bool = true;
			}
		}
		// 如果没有找到对应的cookie值，则创建他，让他该商品数量为1
		if (!bool) {
			CookieUtils.addCookie(id, 1, request, response);
		}
	}

	/** 添加商品cookie */
	public static void addCookie(int id, int num, HttpServletRequest request,
			HttpServletResponse response) {
		Cookie cookie = new Cookie(String.valueOf(id), String.valueOf(num)); // 创建cookie
		System.out.println("创建cookie：" + cookie.getName() + ":"
				+ cookie.getValue());
		cookie.setMaxAge(3600 * 24); // 设置生命周期
		// 设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
		cookie.setPath("/");
		response.addCookie(cookie); // 将cookie写回浏览器
	}
}
