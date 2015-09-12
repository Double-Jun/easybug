package cn.easybuy.domain;

import java.util.Date;

/**
 * 留言评价类
 * 
 * @author mingjun chen
 * 
 */
public class Message {

	private int messageId;
	private String content; // 留言内容
	private Date createTime; // 留言时间

	private int userId; // 用户id
	private int productId; // 商品id

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", content=" + content
				+ ", createTime=" + createTime + ", userId=" + userId
				+ ", productId=" + productId + "]";
	}

}
