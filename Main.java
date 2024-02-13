import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;


    public class Main {

        public static void main(String[] args) {
            Main Main = new Main();
            Main.showToppings();
        }

        //class to hold the price with a setter and a getter
        class PriceHandler{
            public double price;
            public PriceHandler(double price){
                this.price = price;
            }
            public double getPrice() {
                return price;
            }
            public void setPrice(double price) {
                this.price = price;
            }
        }
        public void showToppings() {
            // instance of the pricehandler for the class
            PriceHandler priceHandler = new PriceHandler(0);

            // setting up the JFrame and layout
            JFrame f = new JFrame("Big Y Pizza Shop");
            f.setLayout(new FlowLayout());
            f.setSize(400, 500);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel title = new JLabel("Welcome to the BigY Pizza Shop!");
            title.setFont(new Font("Helvetica", Font.BOLD, 24));
            f.add(title);

            // creating the buttons to select pizza size and adding action listeners for setting the prices
            JLabel heading = new JLabel("Select your pizza size: ");
            heading.setFont(new Font("Helvetica", Font.BOLD, 20));
            f.add(heading);
            JButton small = new JButton("Small $5");
            small.addActionListener(e -> priceHandler.setPrice(5));
            JButton medium = new JButton("Medium $10");
            medium.addActionListener(e -> priceHandler.setPrice(10));
            JButton large = new JButton("Large $15");
            large.addActionListener(e -> priceHandler.setPrice(15));
            JButton xl = new JButton("Super $20");
            xl.addActionListener(e -> priceHandler.setPrice(20));

            // adding the buttons to the JFrame
            f.add(small);
            f.add(medium);
            f.add(large);
            f.add(xl);

            // adding subheading select your toppings and adding prices for the various toppings
            JLabel subheading = new JLabel("Select your toppings: ");
            subheading.setFont(new Font("Helvetica", Font.BOLD, 16));
            JLabel toppingDescription = new JLabel("1 topping = $0.50   2 toppings = $1.00   3 toppings = $1.25");

            // adding the subheading with the "select your toppings" text and the description to the JFrame
            f.add(subheading);
            f.add(toppingDescription);

            // creation of the checkboxes for toppings
            JLabel label = new JLabel("Topping Options (max of 3)");
            JCheckBox k = new JCheckBox("Extra Cheese (no cost)");
            JCheckBox a = new JCheckBox("Mushrooms");
            JCheckBox b = new JCheckBox("Pepperoni");
            JCheckBox c = new JCheckBox("Sausage");
            JCheckBox d = new JCheckBox("Pineapple");
            JCheckBox e = new JCheckBox("Onions");
            JCheckBox g = new JCheckBox("Olives");
            JCheckBox h = new JCheckBox("Bacon");
            JCheckBox i = new JCheckBox("Peppers");
            JCheckBox j = new JCheckBox("Spinach");

            // creation of a vertical box which all the toppings are put into then put into a JScrollPane
            Box box = Box.createVerticalBox();

            // adding the checkboxes to the vertical box
            box.add(label);
            box.add(k);
            box.add(a);
            box.add(b);
            box.add(c);
            box.add(d);
            box.add(e);
            box.add(g);
            box.add(h);
            box.add(i);
            box.add(j);

            // creation and addition of the Jscrollpane to the GUI
            JScrollPane jscrlpBox = new JScrollPane(box);
            jscrlpBox.setPreferredSize(new Dimension(275, 200));
            f.add(jscrlpBox);

            // setting the cost for each additional topping
            double topping1 = 0.50;
            double topping2 = 0.50;
            double topping3 = 0.25;

            // creating a variable to keep track of the number of toppings
            int[] selectedToppings = {0};

            // adjusting the number of selected toppings based on the number of boxes checked
            ItemListener itemListener = e12 -> {
                if (e12.getStateChange() == ItemEvent.SELECTED) {
                    selectedToppings[0]++;
                } else if (e12.getStateChange() == ItemEvent.DESELECTED) {
                    selectedToppings[0]--;
                }

                // updating the pricehandler with the number of selected toppings when toppings are added or removed
                double totalPrice = priceHandler.getPrice();
                if (selectedToppings[0] == 1) {
                    totalPrice += topping1;
                } else if (selectedToppings[0] == 2) {
                    totalPrice += topping2;
                } else if (selectedToppings[0] == 3) {
                    totalPrice += topping3;
                }
                priceHandler.setPrice(totalPrice);

            };

            // adding the itemListener method to each of the checkboxes
            a.addItemListener(itemListener);
            b.addItemListener(itemListener);
            c.addItemListener(itemListener);
            d.addItemListener(itemListener);
            e.addItemListener(itemListener);
            g.addItemListener(itemListener);
            h.addItemListener(itemListener);
            i.addItemListener(itemListener);
            j.addItemListener(itemListener);

            // addition of "complete my order button" at the bottom
            JButton complete = new JButton("Complete my order");
            f.add(complete);


            // action listener for complete my order button
            complete.addActionListener(e1 -> {
                // setting up JFrame with the total cost menu
                JFrame costFrame = new JFrame("Total Cost");
                costFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel costPanel = new JPanel();
                costPanel.setLayout(new FlowLayout());
                // calling the priceHandler to get the subtotal
                double subtotal = priceHandler.getPrice();
                // creating a variable for the sales tax in Massachusetts
                double tax = 0.0625;
                // creating a variable which is the amount of tax
                double taxAmount = tax * subtotal;
                // displaying the math calculating the tax
                JLabel showTax = new JLabel("Cost " + subtotal + " * " + "Tax 6.25% = $" + taxAmount);
                // variable with the total price calculated by adding the subtotal and taxAmount together
                double totalPrice = subtotal + taxAmount;
                // displaying the total cost variable
                JLabel total = new JLabel("Total Cost: $" + totalPrice);
                // setting the fonts of the text in the GUI
                total.setFont(new Font("Helvetica", Font.BOLD, 20));
                showTax.setFont(new Font("Helvetica", Font.BOLD, 20));
                costPanel.setFont(new Font("Helvetica", Font.BOLD, 20));
                // adding the elements to the GUI
                costPanel.add(showTax);
                costPanel.add(total);
                costFrame.add(costPanel);
                // setting the size of the GUI
                costFrame.setSize(300, 200);
                costFrame.setVisible(true);


            });
            f.setVisible(true);
        }
    }
