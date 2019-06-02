package org.supermarket.product;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class DiscountManager {

	private final Map<Integer, Double> rules;

	public DiscountManager() {
		rules = new HashMap<>();
	}

	public void addDiscount(Integer montant, double discount) throws IllegalStateException {
		rules.computeIfPresent(montant, (amount, existedRule) -> {
			throw new IllegalStateException("The discount is already existed.");
		});
		rules.put(montant, discount);
	}

	public void iterateDiscounts(BiFunction<Integer, Double, IteratorState> discountAnalyzer) {
		List<Integer> amounts = getSortedDiscounts();

		int ruleIndex = 0;
		int discountsAmount = amounts.size();

		while (ruleIndex < discountsAmount) {
			Integer ruleAmount = amounts.get(ruleIndex);
			double price = rules.get(ruleAmount);

			IteratorState state = discountAnalyzer.apply(ruleAmount, price);

			if (IteratorState.NEXT_ELEMENT.equals(state)) {
				ruleIndex++;
			}
		}
	}

	private List<Integer> getSortedDiscounts() {
		return rules.keySet().stream().sorted(Comparator.<Integer>reverseOrder()).collect(Collectors.toList());
	}

	public enum IteratorState {
		NEXT_ELEMENT, REPEAT_FOR_CURRENT_ELEMENT
	}

}
