package cn.easybuy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.easybuy.domain.Category;
import cn.easybuy.model.CategoryCustom;
import cn.easybuy.model.ProductCustom;
import cn.easybuy.service.CategoryService;
import cn.easybuy.utils.CategoryUtils;

/**
 * 首页Controller
 * 
 * @author mingjun chen
 *
 */
@Controller
public class IndexController {

	@Resource
	private CategoryService categoryService;

	@RequestMapping("/pageBean")
	public String toPageBean() {
		return "pageBean";
	}

	/** 按商品价格排序 */
	@RequestMapping("/index/sort/{id}/{style}/{arg}")
	public String sort(@PathVariable("id") int id,
			@PathVariable("style") String style,
			@PathVariable("arg") String arg, Model model) {
		List<ProductCustom> categories = categoryService.getByCategoryId(id);
		categories = CategoryUtils.sort(categories, style, arg);
		model.addAttribute("categories", categories);
		model.addAttribute("pId", id);
		model.addAttribute("arg", arg.equals("up") ? "down" : "up");
		return "list";
	}

	/** 访问主页 */
	@RequestMapping("/index")
	public String index(Model model) {
		List<CategoryCustom> categoryCustoms = getAllCatory();
		model.addAttribute("categoryCustoms", categoryCustoms);
		return "index";
	}

	// 准备分类数据（同时表现出分类之间的关系）
	public List<CategoryCustom> getAllCatory() {
		List<Category> categoryList = categoryService.getAll();
		List<CategoryCustom> ccList = new ArrayList<CategoryCustom>();
		for (Category category : categoryList) {
			if (category.getParentId() == 0) {
				CategoryCustom categoryCustom = new CategoryCustom();
				categoryCustom.setCategory(category);
				for (Category c : categoryList) {
					if (c.getParentId() == category.getCategoryId()) {
						categoryCustom.getChildrenList().add(c);
					}
				}
				ccList.add(categoryCustom);
			}
		}
		return ccList;
	}
}
