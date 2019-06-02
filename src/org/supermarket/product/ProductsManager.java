package org.supermarket.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductsManager {

	private final Map<String, Product> products;

	public ProductsManager() {
		this.products = new HashMap<>();
	}

	public Map<String, Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) throws IllegalStateException {
		products.computeIfPresent(product.getName(), (name, existedProduct) -> {
			throw new IllegalStateException("The product with \'" + name + "\' name is already existed.");
		});

		products.put(product.getName(), product);
	}

	public Optional<Product> findProductByName(String name) {
		return Optional.ofNullable(products.get(name));
	}

}
