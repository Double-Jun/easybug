package cn.easybuy.domain;

import java.util.Date;

/**
 * 订单类
 * 
 * @author mingjun chen
 * 
 */
public class Order {

	private int orderId;
	private String name; // 订单名称
	private String address; // 发货地址
	private Date createTime; // 创建时间
	private double totalCost; // 总金额
	private int status; // 状态 未支付，支付，发货，确认收获
	private int type; // 支付类型
	private int userId; // 用户id：表示该订单属于哪个用户

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
