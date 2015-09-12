package cn.easybuy.model;

import cn.easybuy.domain.Category;
import cn.easybuy.domain.Product;

/**
 * 商品和商品分类包装类：封装了Product信息和该商品Category信息
 * 
 * @author mingjun chen
 *
 */
public class ProductCustom {

	private Product product; // 商品
	private Category category; // 商品分类

	private int number; // 商品数量

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductCategory [product=" + product + ", category=" + category
				+ ", number=" + number + "]";
	}

}
