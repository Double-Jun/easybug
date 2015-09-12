package cn.easybuy.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.easybuy.domain.Category;
import cn.easybuy.domain.Product;
import cn.easybuy.service.CategoryService;
import cn.easybuy.service.ProductService;

/**
 * 商品Controller类
 * 
 * @author mingjun chen
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Resource
	private ProductService productService; // 商品业务层
	@Resource
	private CategoryService categoryService; // 商品分类业务层

	/** 商品条件查询 */
	@RequestMapping("/search")
	public String search(String condition, Model model) {
		// String condition = request.getParameter("condition");
		System.out.println("condition:" + condition);
		List<Product> productList = new ArrayList<Product>();
		if (condition != null && condition.trim().length() != 0) {
			productList = productService.search(condition);
		} else {
			// productList = productService.queryAll();
		}
		model.addAttribute("products", productList);
		// productService.search();
		return "list";
	}

	/** 商品修改 */
	@RequestMapping("/edit")
	public String edit(MultipartFile productImg, HttpServletRequest request,
			Product product, String categoryName) {
		productService.edit(product);
		return "redirect:queryAll";
	}

	/** 跳转到商品修改页面 */
	@RequestMapping("/editUI/{id}")
	public ModelAndView editUI(@PathVariable(value = "id") int id,
			HttpServletRequest request) {
		// 准备回显数据,商品信息
		Product product = productService.getById(id);
		// 准备所有商品分类信息
		List<Category> categoryList = categoryService.getAll();
		request.setAttribute("categoryList", categoryList);
		return new ModelAndView("productEdit", "product", product);
	}

	/** 根据id删除商品 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") int id) {
		productService.delete(id);
		return "redirect:../queryAll";
	}

	/** 查询所有商品 */
	@RequestMapping("/queryAll")
	public ModelAndView queryAll() {
		List<Product> productList = productService.queryAll();
		return new ModelAndView("productList", "productList", productList);
	}

	/** 商品添加 （上传商品图片） */
	@RequestMapping("/add")
	public String add(MultipartFile productImg, HttpServletRequest request,
			Product product, String categoryName) {
		// 指定文件保存目录为项目路径下的upload
		// String path = request.getSession().getServletContext()
		// .getRealPath("upload");
		String path = "D:/ecliseCode/easybuy/WebContent/upload";
		// 得到原始文件名
		String fileName = productImg.getOriginalFilename();
		File targetFile = new File(path, fileName);
		product.setImg(fileName); // 设置数据库中图片保存的路径
		productService.add(product);
		// 如果文件上传路径不存在就创建
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			// 保存文件
			productImg.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:queryAll";
	}

	/** 跳转到商品添加页面 */
	@RequestMapping("/addUI")
	public ModelAndView addUI() {
		// 准备数据，得到所有商品分类
		List<Category> categoryList = categoryService.getAll();
		return new ModelAndView("productAdd", "categoryList", categoryList);
	}
}
