package cn.easybuy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

import cn.easybuy.domain.User;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

/**
 * 采用异步发送邮件
 * 
 * @author mingjun chen
 * 
 */
public class SendMail implements Runnable {
	private User user;

	public SendMail(User user) { // 通过构造方法将要发送的用户信息传递过来
		this.user = user;
	}

	@Override
	public void run() {
		String title = "EasyBuy购物商城";
		String content = "<h2>欢迎" + user.getUsername()
				+ "注册EasyBuy商城，这里可以购买您需要商品！</h2>";
		Properties prop = new Properties();
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("mail-config.properties");
		try {
			prop.load(is);
			Session session = MailUtils.createSession(prop.getProperty("SMTP"),
					prop.getProperty("Username"), prop.getProperty("Password"));
			Mail mail = new Mail(prop.getProperty("FromMail"), user.getEmail(),
					title, content);
			MailUtils.send(session, mail);
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
	}

}
