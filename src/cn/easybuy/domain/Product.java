package cn.easybuy.domain;

/**
 * 商品类
 * 
 * @author mingjun chen
 * 
 */
public class Product {

	private int productId;
	private String name; // 商品名称
	private String description; // 商品描述
	private double price; // 商品价格
	private int stock; // 库存量
	private String img; // 商品图片
	private int sales; // 商品销量
	private int categoryId; // 商品类别id：商品所属类别

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name
				+ ", description=" + description + ", price=" + price
				+ ", stock=" + stock + ", img=" + img + ", categoryId="
				+ categoryId + "]";
	}

}
