import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// creating testCart class where the GUI will be
public class testCart {
    public static void main(String[] args) {
        // creating the shopping cart variable
        ShoppingCart shoppingCart = new ShoppingCart();

        // setting up the JFrame
        JFrame f = new JFrame("Welcome to the Shopping Cart");
        f.setLayout(new FlowLayout());
        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setting up the title
        JLabel title = new JLabel("Welcome to the Shopping Cart");
        title.setFont(new Font("Helvetica", Font.BOLD, 22));
        f.add(title);

        // setting up heading
        JLabel heading = new JLabel("Enter the first item");
        heading.setFont(new Font("Helvetica", Font.BOLD, 20));
        heading.setForeground(Color.DARK_GRAY);
        f.add(heading);

        // setting up the header before the first box where an item will be entered
        JTextField itemBox = new JTextField("Enter an item for the shopping list");
        itemBox.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        itemBox.setForeground(Color.BLACK);
        f.add(itemBox);

        // setting up a heading before where the price will be entered
        JLabel priceHeading = new JLabel("Enter the price of the item");
        priceHeading.setFont(new Font("Helvetica", Font.BOLD, 20));
        priceHeading.setForeground(Color.DARK_GRAY);
        f.add(priceHeading);

        // setting up the box where the price will be entered
        JTextField costBox = new JTextField("12.34");
        costBox.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(costBox);

        // setting up the heading to prompt the quantity entry
        JLabel quantityHeading = new JLabel("Enter the quantity of the item");
        quantityHeading.setFont(new Font("Helvetica", Font.BOLD, 20));
        quantityHeading.setForeground(Color.DARK_GRAY);
        f.add(quantityHeading);

        // setting up the box where the quantity will be entered
        JTextField quantityBox = new JTextField("1");
        quantityBox.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(quantityBox);

        // creating the button to add the item to the shopping list
        JButton more = new JButton("Add Item To The Shopping List");
        f.add(more);

        // action listener to add each item to the shopping list when the button is clicked
        more.addActionListener(e1 ->  {
            // setting variables appropriately with what is in each of the boxes
            String newItemName = itemBox.getText();
            double newItemPrice = Double.parseDouble(costBox.getText());
            int newItemQuantity = Integer.parseInt(quantityBox.getText());

            // using the item, itemorder, and shopping cart classes with the data inputted
            Item newItem = new Item(newItemName, newItemPrice);
            ItemOrder newItemOrder = new ItemOrder(newItem, newItemQuantity);
            shoppingCart.addItemOrder(newItemOrder);

            // resetting the boxes to the default values after the item is added to the cart
            itemBox.setText("Enter an item for the shopping list");
            costBox.setText("12.34");
            quantityBox.setText("1");

            // message showing the item was successfully added to the list
            JOptionPane.showMessageDialog(f, "Item added to the shopping list!");

        });

        // creation of the button which shows the list
        JButton complete = new JButton("Complete My Shopping List");
        f.add(complete);

        // action listener used when the complete my shopping list button is pressed
        complete.addActionListener(e2 -> {
            // getting the price from the shopping cart class and setting it
            double totalPrice = shoppingCart.calculateTotalPrice();
            // creating and setting the sales tax
            double salesTax = totalPrice * 0.0625;

            // setting up the new JFrame with the cart
            JFrame listFrame = new JFrame("Shopping List");
            listFrame.setLayout(new BorderLayout());
            listFrame.setSize(325, 200);

            // getting the information about each item and adding it to the list to display
            DefaultListModel<String> model = new DefaultListModel<>();
            for (ItemOrder itemOrder : shoppingCart.getItemOrders()) {
                Item item = itemOrder.getItem();
                int quantity = itemOrder.getQuantity();
                model.addElement(item.getGood() + " - $" + item.getPrice() + " x " + quantity);
            }
            JList<String> list = new JList<>(model);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only one item to be selected
            JScrollPane scrollPane = new JScrollPane(list);

            // creating the remove button to remove groceries after clicking on them and clicking remove on the list
            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = list.getSelectedIndex();
                    if (selectedIndex != -1) {
                        shoppingCart.removeItemOrder(shoppingCart.getItemOrders().get(selectedIndex));
                        model.remove(selectedIndex);
                        JOptionPane.showMessageDialog(listFrame, "Item removed from the shopping list!");
                    } else {
                        JOptionPane.showMessageDialog(listFrame, "Please select an item to remove.");
                    }
                }
            });

            // displaying the total price and sales tax
            JLabel totalLabel = new JLabel("Total Price: $" + totalPrice + "  Sales Tax: $" + salesTax);
            totalLabel.setFont(new Font("Helvetica", Font.BOLD, 16));

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(removeButton);

            listFrame.add(scrollPane, BorderLayout.CENTER);
            listFrame.add(totalLabel, BorderLayout.NORTH);
            listFrame.add(buttonPanel, BorderLayout.SOUTH);
            listFrame.setVisible(true);
        });

        f.setVisible(true);
    }
}
