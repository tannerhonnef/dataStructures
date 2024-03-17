import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

// creation of the demo pizza class
public class demoPizza {
    // variable to keep track of the number of selected toppings
    private static int[] selectedToppings = {0};

    public static void main(String[] args) {
        // Call the showToppings() method
        showToppings();
    }
    // setting up the JFrame and layout.  Much of the code is reused from the previous pizza assignment
    public static void showToppings() {
        JFrame f = new JFrame("Big Y Pizza Shop");
        f.setLayout(new FlowLayout());
        f.setSize(400, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel("Welcome to the BigY Pizza Shop!");
        title.setFont(new Font("Helvetica", Font.BOLD, 24));
        f.add(title);

        JLabel description = new JLabel("Pizza is $14 and each topping is $2");
        JLabel deliveryDescription = new JLabel("$3 delivery for 2+ toppings.  $5 delivery for 0 or 1 toppings.");
        f.add(description);
        f.add(deliveryDescription);

        // adding subheading select your toppings and adding prices for the various toppings
        JLabel subheading = new JLabel("Select your toppings: ");
        subheading.setFont(new Font("Helvetica", Font.BOLD, 16));

        // adding the subheading with the "select your toppings" text and the description to the JFrame
        f.add(subheading);

        // creation of the checkboxes for toppings
        JLabel label = new JLabel("Topping Options (Max of 10)");
        JCheckBox a = new JCheckBox("Mushrooms");
        JCheckBox b = new JCheckBox("Pepperoni");
        JCheckBox c = new JCheckBox("Sausage");
        JCheckBox d = new JCheckBox("Pineapple");
        JCheckBox e = new JCheckBox("Onions");
        JCheckBox g = new JCheckBox("Olives");
        JCheckBox h = new JCheckBox("Bacon");
        JCheckBox i = new JCheckBox("Peppers");
        JCheckBox j = new JCheckBox("Spinach");
        JCheckBox k = new JCheckBox("Bacon");
        JCheckBox l = new JCheckBox("Artichokes");
        JCheckBox m = new JCheckBox("Feta");
        JCheckBox n = new JCheckBox("Tomatoes");

        // creation of a vertical box which all the toppings are put into then put into a JScrollPane
        Box box = Box.createVerticalBox();

        // adding the checkboxes to the vertical box
        box.add(label);
        box.add(a);
        box.add(b);
        box.add(c);
        box.add(d);
        box.add(e);
        box.add(g);
        box.add(h);
        box.add(i);
        box.add(j);
        box.add(k);
        box.add(l);
        box.add(m);
        box.add(n);

        // creation and addition of the JScrollPane to the GUI
        JScrollPane jscrlpBox = new JScrollPane(box);
        jscrlpBox.setPreferredSize(new Dimension(275, 200));
        f.add(jscrlpBox);

        // item listener keeping track of the number of items being checked and not allowing there to be more than 10
        ItemListener itemListener = e12 -> {
            if (e12.getStateChange() == ItemEvent.SELECTED) {
                if (selectedToppings[0] >= 10) {
                    ((JCheckBox) e12.getItem()).setSelected(false);
                } else {
                    selectedToppings[0]++;
                }
            } else if (e12.getStateChange() == ItemEvent.DESELECTED) {
                selectedToppings[0]--;
            }
        };

        // adding the item listener to each topping
        a.addItemListener(itemListener);
        b.addItemListener(itemListener);
        c.addItemListener(itemListener);
        d.addItemListener(itemListener);
        e.addItemListener(itemListener);
        g.addItemListener(itemListener);
        h.addItemListener(itemListener);
        i.addItemListener(itemListener);
        j.addItemListener(itemListener);
        k.addItemListener(itemListener);
        l.addItemListener(itemListener);
        m.addItemListener(itemListener);
        n.addItemListener(itemListener);

        // adding the "complete my order for pickup button" at the bottom
        JButton complete = new JButton("Complete my pickup order");
        f.add(complete);

        // adding the "complete my order for delivery button" at the bottom
        JButton delivery = new JButton("Complete my delivery order");
        f.add(delivery);

        // action listener for the delivery button where user will be prompted for an address
        delivery.addActionListener(e2 -> {
            JFrame deliveryAddress = new JFrame("Your Delivery Address");
            JLabel addressInfo = new JLabel("Please enter your delivery address");
            JTextField houseNum = new JTextField("950 Main Street");
            JLabel houseNumL = new JLabel("Enter the house number, street, and zip code");
            JButton completeAddress = new JButton("Complete my Order");
            deliveryAddress.setLayout(new GridLayout(4, 1));
            deliveryAddress.add(addressInfo);
            deliveryAddress.add(houseNumL);
            deliveryAddress.add(houseNum);
            deliveryAddress.add(completeAddress);
            deliveryAddress.pack();
            deliveryAddress.setVisible(true);

            // action listener to progress to the final menu which shows the total price and the delivery address
            completeAddress.addActionListener(e3 -> {
                // Get the selected toppings
                String[] selectedToppingsArray = new String[10];
                int index = 0;
                if (a.isSelected()) selectedToppingsArray[index++] = "Mushrooms";
                if (b.isSelected()) selectedToppingsArray[index++] = "Pepperoni";
                if (c.isSelected()) selectedToppingsArray[index++] = "Sausage";
                if (d.isSelected()) selectedToppingsArray[index++] = "Pineapple";
                if (e.isSelected()) selectedToppingsArray[index++] = "Onions";
                if (g.isSelected()) selectedToppingsArray[index++] = "Olives";
                if (h.isSelected()) selectedToppingsArray[index++] = "Bacon";
                if (i.isSelected()) selectedToppingsArray[index++] = "Peppers";
                if (j.isSelected()) selectedToppingsArray[index++] = "Spinach";
                if (k.isSelected()) selectedToppingsArray[index++] = "Bacon";
                if (l.isSelected()) selectedToppingsArray[index++] = "Artichokes";
                if (m.isSelected()) selectedToppingsArray[index++] = "Feta";
                if (n.isSelected()) selectedToppingsArray[index++] = "Tomatoes";

                // creating a DeliveryPizza with selected toppings and delivery address
                deliveryPizza deliveryPizza = new deliveryPizza(Arrays.copyOf(selectedToppingsArray, index), houseNum.getText(), index);

                // creating and populating the "Your Delivery Order" frame
                JFrame deliveryOrder = new JFrame("Your Delivery Order");
                deliveryOrder.setLayout(new GridLayout(10, 1));
                JLabel orderLabel = new JLabel("Your Pizza: ");
                orderLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
                JLabel pizzaDetailsLabel = new JLabel(deliveryPizza.toString());
                JLabel totalPriceLabel = new JLabel("Total Price with sales tax: $" + (deliveryPizza.calculateTotalPrice()));
                totalPriceLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
                deliveryOrder.add(orderLabel);
                deliveryOrder.add(pizzaDetailsLabel);
                deliveryOrder.add(totalPriceLabel);
                deliveryOrder.pack();
                deliveryOrder.setVisible(true);

                // closing the delivery address frame when it is done being used
                deliveryAddress.dispose();
            });

            deliveryAddress.setLayout(new GridLayout(4, 1));
            deliveryAddress.add(addressInfo);
            deliveryAddress.add(houseNumL);
            deliveryAddress.add(houseNum);
            deliveryAddress.add(completeAddress);

            deliveryAddress.pack();
            deliveryAddress.setVisible(true);
        });

        complete.addActionListener(e1 -> {
            // Get the selected toppings
            String[] selectedToppingsArray = new String[10];
            int index = 0;
            if (a.isSelected()) selectedToppingsArray[index++] = "Mushrooms";
            if (b.isSelected()) selectedToppingsArray[index++] = "Pepperoni";
            if (c.isSelected()) selectedToppingsArray[index++] = "Sausage";
            if (d.isSelected()) selectedToppingsArray[index++] = "Pineapple";
            if (e.isSelected()) selectedToppingsArray[index++] = "Onions";
            if (g.isSelected()) selectedToppingsArray[index++] = "Olives";
            if (h.isSelected()) selectedToppingsArray[index++] = "Bacon";
            if (i.isSelected()) selectedToppingsArray[index++] = "Peppers";
            if (j.isSelected()) selectedToppingsArray[index++] = "Spinach";
            if (k.isSelected()) selectedToppingsArray[index++] = "Bacon";
            if (l.isSelected()) selectedToppingsArray[index++] = "Artichokes";
            if (m.isSelected()) selectedToppingsArray[index++] = "Feta";
            if (n.isSelected()) selectedToppingsArray[index++] = "Tomatoes";

            // Creating a Pizza with selected toppings
            pizza pizza = new pizza(Arrays.copyOf(selectedToppingsArray, index), index);

            // creating and populating the "Your Takeout Order" frame
            JFrame takeout = new JFrame("Your Takeout Order");
            takeout.setLayout(new GridLayout(5,1));
            JLabel orderLabel = new JLabel("Your Pizza:");
            orderLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
            JLabel pizzaDetailsLabel = new JLabel(pizza.toString());
            JLabel totalPriceLabel = new JLabel("Total Price with sales tax: $" + (pizza.calculateTotalPrice()));
            totalPriceLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
            takeout.add(orderLabel);
            takeout.add(pizzaDetailsLabel);
            takeout.add(totalPriceLabel);
            takeout.pack();
            takeout.setVisible(true);
        });

        f.setVisible(true);
    }
}