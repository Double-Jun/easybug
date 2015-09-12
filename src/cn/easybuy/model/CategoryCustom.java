package cn.easybuy.model;

import java.util.ArrayList;
import java.util.List;

import cn.easybuy.domain.Category;

/***
 * 商品分类包装类：用于封装一个分类和此分类下的所有子类
 * 
 * @author mingjun chen
 *
 */
public class CategoryCustom {
	private Category category; // 分类
	private List<Category> childrenList = new ArrayList<Category>(); // 此分类下的子类

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getChildrenList() {
		return childrenList;
	}

	public void setChildrenList(List<Category> childrenList) {
		this.childrenList = childrenList;
	}

}
