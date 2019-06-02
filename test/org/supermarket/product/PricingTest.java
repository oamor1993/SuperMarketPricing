package org.supermarket.product;

import org.junit.jupiter.api.Test;

class PricingTest {

	// test to add a product
	@Test
	void addProductTest() {
		ProductsManager productsManager = new ProductsManager();
		Product product1 = new Product("A", 50, new DiscountManager());
		productsManager.addProduct(product1);
		System.out.println("Products :");
		System.out.println(productsManager.getProducts().toString());

	}

	// test to add products
	@Test
	void addProductsTest() {
		ProductsManager productsManager = new ProductsManager();
		Product product1 = new Product("A", 50, new DiscountManager());
		Product product2 = new Product("B", 50, new DiscountManager());
		Product product3 = new Product("C", 50, new DiscountManager());
		Product product4 = new Product("D", 50, new DiscountManager());
		productsManager.addProduct(product1);
		productsManager.addProduct(product2);
		productsManager.addProduct(product3);
		productsManager.addProduct(product4);
		System.out.println("Products :");
		System.out.println(productsManager.getProducts().toString());

	}

	//// test to create products with simples prices
	@Test
	void addProductwithSimplePriceTest() {

		Product produit1 = new Product("A", 0.50, new DiscountManager());
		System.out.println("\n ***Example with simple price :");
		System.out.println(produit1.toString());
		System.out.println(" quantity : 3 , price =  " + produit1.getPriceForAmount(3));
		System.out.println(" quantity : 5 , price =  " + produit1.getPriceForAmount(5));
	}

	// test to create products with discounts
	@Test
	void addProductwithDiscountsTest() {

		Product produit1 = new Product("A", 50, new DiscountManager());
		produit1.getDiscountmanager().addDiscount(2, 75);
		produit1.getDiscountmanager().addDiscount(3, 90);

		System.out.println(produit1.toString() + "\n discount : 2 for 75 and 3 for 90");
		System.out.println(" quantity : 2 , price = " + produit1.getPriceForAmount(2));
		System.out.println(" quantity : 3 , price = " + produit1.getPriceForAmount(3));
		System.out.println(" quantity : 5 , price =  " + produit1.getPriceForAmount(5));
		System.out.println(" quantity : 6 , price = " + produit1.getPriceForAmount(6) + "\n");

		Product produit2 = new Product("B", 30, new DiscountManager());
		produit2.getDiscountmanager().addDiscount(4, 100);
		System.out.println(produit2.toString() + " \n discount :  4 for 100");
		System.out.println(" quantity : 5  , price =  " + produit2.getPriceForAmount(5));
		System.out.println(" quantity : 9  , price =  " + produit2.getPriceForAmount(9) + "\n");

		Product produit3 = new Product("C", 12, new DiscountManager());
		produit3.getDiscountmanager().addDiscount(10, 150);
		System.out.println(produit3.toString() + "\n discount : 10 for 150");
		System.out.println("quantity : 11  , price =  " + produit3.getPriceForAmount(11) + "\n");
	}

	// example with 3 for 1 dollar(so what's the price if i buy 4 or 5 ?)
	@Test
	void addProductwithThreeforOneDollarTest() {
		Product produit4 = new Product("D", 0.4, new DiscountManager());
		produit4.getDiscountmanager().addDiscount(3, 1);
		System.out.println("\n ***Example with 3 for 1 dollar(so what's the price if i buy 4 or 5 ?)");
		System.out.println(produit4.toString());
		System.out.println(" quantity : 3  , price =   " + produit4.getPriceForAmount(3));
		System.out.println(" quantity : 4  , price =   " + produit4.getPriceForAmount(4));
		System.out.println(" quantity : 5  , price =   " + produit4.getPriceForAmount(5));
		System.out.println(" quantity : 6  , price =   " + produit4.getPriceForAmount(6) + "\n");
	}

	// example with buy two, get one free
	@Test
	void addProductwithDicountBuytwogetOneFreeTest() {
		Product produit5 = new Product("E", 10.5, new DiscountManager());
		produit5.getDiscountmanager().addDiscount(3, 21.0);
		System.out.println("\n ***Example with buy two, get one free");
		System.out.println(produit5.toString());
		System.out.println(" quantity : 2  , price =  " + produit5.getPriceForAmount(2));
		System.out.println(" quantity : 3  , price =  " + produit5.getPriceForAmount(3));
		System.out.println(" quantity : 4  , price =  " + produit5.getPriceForAmount(4));
		System.out.println(" quantity : 6  , price =  " + produit5.getPriceForAmount(6));
	}

	// example with 1.99/pound (so what does the third item have a price ?)
	@Test
	void addProductwithPoundAndOunceTest() {
		Product produit6 = new Product("F", 1.99, new DiscountManager());
		produit6.getDiscountmanager().addDiscount(4, 1.99 / 4);
		System.out.println("\n ***Example with 1.99/pound (so what does 4 ounces cost ?)");
		System.out.println(produit6.toString() + "\n $1.99/pound");
		System.out.println(" quantity : 4 ounces  , price =  " + produit6.getPriceForAmount(4));

	}

}
