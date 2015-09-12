package cn.easybuy.domain;

/**
 * 订单详细
 * 
 * @author mingjun chen
 * 
 */
public class OrderDetail {

	private int detailId;
	private int number; // 数量
	private double cost; // 总价
	private int orderId; // 订单id
	private int productId; // 商品id

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
