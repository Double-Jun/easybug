package cn.easybuy.domain;

/**
 * 产品类别
 * 
 * @author mingjun chen
 * 
 */
public class Category {

	private int categoryId; // 商品分类id
	private String name; // 名称
	private String description; // 描述
	private int parentId; // 上级分类id

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", name=" + name
				+ ", description=" + description + "]";
	}

}
