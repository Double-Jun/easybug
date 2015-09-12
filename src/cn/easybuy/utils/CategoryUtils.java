package cn.easybuy.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.easybuy.model.ProductCustom;

public class CategoryUtils {

	/** 对商品集合制定方式进行排序 */
	public static List<ProductCustom> sort(List<ProductCustom> categories,
			String style, String arg) {
		if (style.equals("price") && arg.equals("up")) {
			Comparator<ProductCustom> comparator = new Comparator<ProductCustom>() {
				@Override
				public int compare(ProductCustom o1, ProductCustom o2) {
					return (int) (o1.getProduct().getPrice() - o2.getProduct()
							.getPrice());
				}
			};
			Collections.sort(categories, comparator);
		} else if (style.equals("price") && arg.equals("down")) {
			Comparator<ProductCustom> comparator = new Comparator<ProductCustom>() {
				@Override
				public int compare(ProductCustom o1, ProductCustom o2) {
					return (int) (o2.getProduct().getPrice() - o1.getProduct()
							.getPrice());
				}
			};
			Collections.sort(categories, comparator);
		} else if (style.equals("sales") && arg.equals("up")) {
			Comparator<ProductCustom> comparator = new Comparator<ProductCustom>() {
				@Override
				public int compare(ProductCustom o1, ProductCustom o2) {
					return (int) (o1.getProduct().getSales() - o2.getProduct()
							.getSales());
				}
			};
			Collections.sort(categories, comparator);
		} else if (style.equals("sales") && arg.equals("down")) {
			Comparator<ProductCustom> comparator = new Comparator<ProductCustom>() {
				@Override
				public int compare(ProductCustom o1, ProductCustom o2) {
					return (int) (o2.getProduct().getSales() - o1.getProduct()
							.getSales());
				}
			};
			Collections.sort(categories, comparator);
		}

		return categories;
	}
}