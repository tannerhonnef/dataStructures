import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ItemOrder> itemOrders;

    public ShoppingCart() {
        this.itemOrders = new ArrayList<>();
    }

    public void addItemOrder(ItemOrder itemOrder) {
        itemOrders.add(itemOrder);
    }

    public void removeItemOrder(ItemOrder itemOrder) {
        itemOrders.remove(itemOrder);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (ItemOrder itemOrder : itemOrders) {
            totalPrice += itemOrder.calculateCost();
        }
        return totalPrice;
    }

    public List<ItemOrder> getItemOrders() {
        return itemOrders;
    }
}
