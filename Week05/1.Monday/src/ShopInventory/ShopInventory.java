package ShopInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopInventory {

	private List<Product> products = new ArrayList<>();
	
	public ShopInventory(List<Product> products) {
	
		this.products.addAll(products);
	}
	
	public double Audit(){
		
		double total = 0;
		for (Product product : products) {
			
			total += product.getPriceAfterTax() * product.getQuantity();
		}
		
		return total;
	}
	
	private int getProductIndex(int productId){
		
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductId() == productId){
				return i;
			}
		}
		
		return -1; // if the product was not found, return -1
	}
	
	public double RequestOrder(Order order) throws NotAvailableInInventoryException{
		
		Map<Integer, Integer> orderList = order.getOrders();
		double totalCost = 0;

		int curIndex;
		for (Map.Entry<Integer, Integer> item : orderList.entrySet()) {
			
			curIndex = getProductIndex(item.getKey());
			
			if(curIndex == -1 || products.get(curIndex).getQuantity() < item.getValue()){
				throw new NotAvailableInInventoryException("ERROR: The inventory doesn't contain all the required products.");
			}
			
			totalCost += products.get(curIndex).getPriceAfterTax() * item.getValue();
		}
		
		return totalCost; 
	}
}
