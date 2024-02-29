// done with Sai Nikhil Chanda
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.time.LocalDate;

public class testWedding {
    public static void main(String[] args) {
        // setting up the wedding frame
        JFrame f = new JFrame("Welcome to the Wedding Planner");
        f.setLayout(new FlowLayout());
        f.setSize(350, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel("Welcome to the Wedding Planner");
        // setting font type
        title.setFont(new Font("Helvetica", Font.BOLD, 22));
        f.add(title);

        // setting up heading
        JLabel heading = new JLabel("Set the couple's name's");
        heading.setFont(new Font("Helvetica", Font.BOLD, 20));
        heading.setForeground(Color.DARK_GRAY);
        f.add(heading);

        // setting up the Bride's First Name input
        JTextField brideFName = new JTextField("Enter the first name of the bride");
        brideFName.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        brideFName.setForeground(Color.PINK);
        f.add(brideFName);

        // setting up the Bride's Last Name input
        JTextField brideLName = new JTextField("Enter the last name of the bride");
        brideLName.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        brideLName.setForeground(Color.PINK);
        f.add(brideLName);

        // setting up the Groom's First Name input
        JTextField groomFName = new JTextField("Enter the first name of the groom");
        groomFName.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        groomFName.setForeground(Color.BLUE);
        f.add(groomFName);

        // setting up the Groom's Last Name input
        JTextField groomLName = new JTextField("Enter the last name of the groom");
        groomLName.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        groomLName.setForeground(Color.BLUE);
        f.add(groomLName);

        // setting up the wedding date input
        JLabel date = new JLabel("Enter the date of the wedding");
        date.setFont(new Font("Helvetica", Font.BOLD, 20));
        date.setForeground(Color.DARK_GRAY);
        f.add(date);

        // getting the year of the wedding
        JTextField weddingYear = new JTextField("YYYY");
        weddingYear.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(weddingYear);

        // getting the month of the wedding
        JTextField weddingMonth = new JTextField("MM");
        weddingMonth.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(weddingMonth);

        // getting the day of the wedding
        JTextField weddingDay = new JTextField("DD");
        weddingDay.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(weddingDay);

        // getting the venue of the wedding
        JLabel venue = new JLabel("Enter the venue of the wedding");
        // setting the font of the text
        venue.setFont(new Font("Helvetica", Font.BOLD, 20));
        venue.setForeground(Color.DARK_GRAY);
        f.add(venue);
        JTextField weddingLocation = new JTextField("Location of the Wedding");
        weddingLocation.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(weddingLocation);

        // setting the button up to go to the next screen
        JButton complete = new JButton("Complete my wedding");
        f.add(complete);

        // action listener for the button
        complete.addActionListener(e1 -> {
                    // setting up the next frame
                    JFrame weddingFrame = new JFrame("Wedding");
                    weddingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JPanel weddingTest = new JPanel();
                    weddingTest.setLayout(new GridLayout(4,1));

                    // grabbing the user input for names
                    String bLName = brideLName.getText();
                    String bFName = brideFName.getText();
                    String gFName = groomFName.getText();
                    String gLName = groomLName.getText();

                    // grabbing the user input for date
                    LocalDate wDate = LocalDate.of(Integer.parseInt(weddingYear.getText()), Integer.parseInt(weddingMonth.getText()), Integer.parseInt(weddingDay.getText()));

                    // grabbing the user input for location
                    String wLocation = weddingLocation.getText();

                    // creating objects for each input
                    Person groom = new Person(gFName, gLName);
                    Person bride = new Person(bFName, bLName);
                    Couple couple1 = new Couple(bride, groom);
                    Wedding wedding1 =  new Wedding(couple1, wDate, wLocation);

                    // setting up for display of the the user inputs
                    JLabel groomNameDisplay = new JLabel("The groom's name is: " + groom.getFirstName() + " " + groom.getLastName(), SwingConstants.CENTER);
                    JLabel brideNameDisplay = new JLabel("The bride's name is: " + bride.getFirstName() + " " + bride.getLastName(), SwingConstants.CENTER);
                    JLabel dateDisplay = new JLabel("The date of the wedding is: " + wedding1.getWeddingDate(), SwingConstants.CENTER);
                    JLabel wLocationDisplay = new JLabel("The location of the wedding is: " + wedding1.getLocation(), SwingConstants.CENTER);

                    // displaying the user inputs
                    weddingTest.add(groomNameDisplay);
                    weddingTest.add(brideNameDisplay);
                    weddingTest.add(dateDisplay);
                    weddingTest.add(wLocationDisplay);

                    // setting the size of the frame
                    weddingFrame.setSize(600, 500);
                    weddingFrame.add(weddingTest);
                    weddingTest.setVisible(true);
                    weddingFrame.setVisible((true));
                });


            f.setVisible(true);
    }
}