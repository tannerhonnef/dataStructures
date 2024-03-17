// the delivery pizza inherits functions from pizza and adds a delivery fee and a delivery address
public class deliveryPizza extends pizza {
    private double deliveryFee;
    private String deliveryAddress;
    private double totalPrice;

    // constructor which calls the parent class wtih the toppings and number of toppings
    public deliveryPizza(String[] toppings, String deliveryAddress, int numberOfToppings) {
        super(toppings, numberOfToppings);
        this.deliveryAddress = deliveryAddress;
        calculateDeliveryFee();
    }

    // calculates the delivery fee based on the number of toppings
    private void calculateDeliveryFee() {
        if (super.getPrice() > 18) {
            this.deliveryFee = 3;
        } else {
            this.deliveryFee = 5;
        }
    }
    // creates a string with the delivery address and delivery fee
    public String toString() {
        return super.toString() + ". Delivery Address " + deliveryAddress + ". Delivery Fee: $" + deliveryFee;
    }
    // calculates the total price which is pizza price plus the delivery fee plus the sales tax
    public Double calculateTotalPrice() {
        return totalPrice = (deliveryFee + price) * 1.0625;
    }

}

