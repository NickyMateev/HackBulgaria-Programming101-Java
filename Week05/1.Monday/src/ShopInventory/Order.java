package ShopInventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
	
	private Map<Integer, Integer> orders = new HashMap<>();
	
	public Order(Map<Integer, Integer> order) {
		
		this.orders.putAll(order);
	}
	
	public Order(List<Integer> productIds, List<Integer> quantities) throws InvalidProductListException {
		
		if(productIds.size() != quantities.size()){
			throw new InvalidProductListException("ERROR: The Product ID's list and the Qunatities list cannot have different lengths!");
		}

		for (int i = 0; i < productIds.size(); i++) {
			orders.put(productIds.get(i), quantities.get(i));
		}
	}
	
	public int getOrderSize(){
		return orders.size();
	}
	
	public Map<Integer, Integer> getOrders(){
		return orders;
	}

}
