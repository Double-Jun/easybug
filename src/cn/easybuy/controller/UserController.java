package cn.easybuy.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.easybuy.domain.User;
import cn.easybuy.service.UserService;
import cn.easybuy.utils.SendMail;
import cn.easybuy.utils.VerifyCode;

/**
 * 用户Controller
 * 
 * @author mingjun chen
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	/** 图片验证码 */
	@RequestMapping("/verifyCode")
	public void verifyCode(HttpServletRequest request,
			HttpServletResponse response) {
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();// 获取一次性验证码图片
		// 该方法必须在getImage()方法之后来调用
		try {
			VerifyCode.output(image, response.getOutputStream());// 把图片写到指定流中
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 把文本保存到session中，为LoginServlet验证做准备
		request.getSession().setAttribute("vCode", vc.getText());
	}

	@RequestMapping("/login")
	public String login(String username, String password,
			HttpServletRequest request) {
		User user = userService.login(username, password);
		if (user != null) {
			// 登录成功，将用户名保存到Session中
			user.setPassword(null);
			request.getSession().setAttribute("user", user);
			return "redirect:../index";
		} else {
			// 登录失败，返回登录页面
			System.out.println("登录失败，用户名或密码错误！" + username + ":" + password);
			return loginUI();
		}
	}

	/** 跳转到登陆页面 */
	@RequestMapping("/loginUI")
	public String loginUI() {
		return "login";
	}

	/** 用户注册 */
	@RequestMapping(value = "/regist")
	public String regist(User user, String checkcode,
			HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println(request.getSession().getAttribute("vCode") + "=="
				+ checkcode);
		if (request.getSession().getAttribute("vCode").toString().toUpperCase()
				.equals(checkcode.toUpperCase())) {
			userService.regist(user);
			// 采用异步发送邮件
			new Thread(new SendMail(user)).start();
		} else {
			System.out.println("验证码错误");
			return "regist";
		}
		return "success";
	}

	/** 跳转到用户注册页面 */
	@RequestMapping("/registUI")
	public String registUI() {
		return "regist";
	}

}
