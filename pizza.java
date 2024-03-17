public class pizza {
    // creating the variables
    public String[] toppings;
    public double price;
    public double takeoutTotalPrice;

    // keeping track of the toppings and calling calculate price to get the price based on the number of toppings
    public pizza(String[] toppings, int numberOfToppings) {
        this.toppings = new String[numberOfToppings];
        for (int i = 0; i < numberOfToppings; i++) {
            this.toppings[i] = toppings[i];
        }
        calculatePrice(numberOfToppings);
    }

    // calculating the price of the pizza based on the number of toppings
    private void calculatePrice(int numberOfToppings) {
        this.price = 14;
        this.price += 2 * numberOfToppings;
    }

    // getter for the price variable
    public double getPrice() {
        return price;
    }
    // calculator for the total price which includes sales tax
    public Double calculateTotalPrice() {
        return takeoutTotalPrice = price * 1.0625;
    }
    // creation of the string with the necessary details about the pizza with the exception of the total price of the pizza including the sales tax
    public String toString() {
        StringBuilder description = new StringBuilder("Pizza with toppings: ");
        for (int i = 0; i < toppings.length; i++){
            description.append(toppings[i]);
            if (i < toppings.length - 1) {
                description.append(", ");
            }
        }
        description.append(". Price: $").append(price);
        return description.toString();
    }
}

