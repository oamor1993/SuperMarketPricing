package org.supermarket.product;

import static org.supermarket.product.DiscountManager.IteratorState.NEXT_ELEMENT;
import static org.supermarket.product.DiscountManager.IteratorState.REPEAT_FOR_CURRENT_ELEMENT;

import java.util.Objects;

public class Product {

	private String name;
	private double price;
	DiscountManager discountmanager;

	public Product() {
	}

	public Product(String name, double price, DiscountManager discountmanager) {
		super();
		this.name = name;
		this.price = price;
		this.discountmanager = discountmanager;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (!(o instanceof Product)) {
			return false;
		}

		Product product = (Product) o;
		return Objects.equals(name, product.name) && Objects.equals(price, product.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public String toString() {
		return String.format("\'%s\' product with price %s", name.toString(), price);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public DiscountManager getDiscountmanager() {
		return discountmanager;
	}

	public void setDiscountmanager(DiscountManager discountmanager) {
		this.discountmanager = discountmanager;
	}

	public double getPriceForAmount(int amount) {
		if (amount == 1) {
			return price;
		}

		return getPriceWithDiscount(amount);
	}

	private double resultPrice;
	private int classamount;

	private double getPriceWithDiscount(int amount) {
		this.resultPrice = 0;
		this.classamount = amount;
		discountmanager.iterateDiscounts((productAmountForDiscount, discountPrice) -> {
			if (productAmountForDiscount > classamount) {
				return NEXT_ELEMENT;
			}

			classamount -= productAmountForDiscount;
			resultPrice += discountPrice;

			return REPEAT_FOR_CURRENT_ELEMENT;
		});

		if (classamount != 0) {
			double productPrice = price * classamount;
			resultPrice += productPrice;
		}

		return resultPrice;
	}
}
