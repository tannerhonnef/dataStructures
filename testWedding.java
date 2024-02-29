// done with Sai Nikhil Chanda
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.time.LocalDate;

public class testWedding {
    public static void main(String[] args) {
        JFrame f = new JFrame("Welcome to the Wedding Planner");
        f.setLayout(new FlowLayout());
        f.setSize(350, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel("Welcome to the Wedding Planner");
        title.setFont(new Font("Helvetica", Font.BOLD, 22));
        f.add(title);

        JLabel heading = new JLabel("Set the couple's name's");
        heading.setFont(new Font("Helvetica", Font.BOLD, 20));
        f.add(heading);
        JTextField brideFName = new JTextField("Enter the first name of the bride");
        brideFName.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(brideFName);

        JTextField brideLName = new JTextField("Enter the last name of the bride");
        brideLName.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(brideLName);


        JTextField groomFName = new JTextField("Enter the first name of the groom");
        groomFName.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(groomFName);

        JTextField groomLName = new JTextField("Enter the last name of the groom");
        groomLName.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(groomLName);

        JLabel date = new JLabel("Enter the date of the wedding");
        date.setFont(new Font("Helvetica", Font.BOLD, 20));
        f.add(date);

        JTextField weddingYear = new JTextField("YYYY");
        weddingYear.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(weddingYear);

        JTextField weddingMonth = new JTextField("MM");
        weddingMonth.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(weddingMonth);

        JTextField weddingDay = new JTextField("DD");
        weddingDay.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(weddingDay);




        JLabel venue = new JLabel("Enter the venue of the wedding");
        venue.setFont(new Font("Helvetica", Font.BOLD, 20));
        f.add(venue);
        JTextField weddingLocation = new JTextField("Location of the Wedding");
        weddingLocation.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 20));
        f.add(weddingLocation);

        JButton complete = new JButton("Complete my wedding");
        f.add(complete);

        complete.addActionListener(e1 -> {
                    JFrame weddingFrame = new JFrame("Wedding");
                    weddingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JPanel weddingTest = new JPanel();
                    weddingTest.setLayout(new GridLayout(4,1));

                    String bLName = brideLName.getText();
                    String bFName = brideFName.getText();
                    String gFName = groomFName.getText();
                    String gLName = groomLName.getText();

                    LocalDate wDate = LocalDate.of(Integer.parseInt(weddingYear.getText()), Integer.parseInt(weddingMonth.getText()), Integer.parseInt(weddingDay.getText()));

                    String wLocation = weddingLocation.getText();

                    Person groom = new Person(gFName, gLName);
                    Person bride = new Person(bFName, bLName);

                    Couple couple1 = new Couple(bride, groom);

                    Wedding wedding1 =  new Wedding(couple1, wDate, wLocation);

                    JLabel groomNameDisplay = new JLabel("The groom's name is: " + groom.getFirstName() + " " + groom.getLastName(), SwingConstants.CENTER);
                    JLabel brideNameDisplay = new JLabel("The bride's name is: " + bride.getFirstName() + " " + bride.getLastName(), SwingConstants.CENTER);

                    JLabel dateDisplay = new JLabel("The date of the wedding is: " + wedding1.getWeddingDate(), SwingConstants.CENTER);
                    JLabel wLocationDisplay = new JLabel("The location of the wedding is: " + wedding1.getLocation(), SwingConstants.CENTER);

                    weddingTest.add(groomNameDisplay);
                    weddingTest.add(brideNameDisplay);
                    weddingTest.add(dateDisplay);
                    weddingTest.add(wLocationDisplay);
                    weddingFrame.setSize(600, 500);
                    weddingFrame.add(weddingTest);
                    weddingTest.setVisible(true);
                    weddingFrame.setVisible((true));
                });


            f.setVisible(true);
    }
}