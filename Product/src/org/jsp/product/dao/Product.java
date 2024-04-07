package org.jsp.product.dao;

public interface Product {

	void saveProduct();

	void updateProduct();

	void findProductById();

	void deleteProductById();

	void findProductByBrand();

	void findProductByCate();

	void filterProductByCost();
}
