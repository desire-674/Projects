import javax.swing.*;   		 // for GUI
import java.awt.*;				//GUI tools such as buttons etc
import java.awt.event.ActionEvent;        //for events like onclick etc
import java.awt.event.ActionListener;     //for cursor and click actions
import java.sql.*; 			  // imports sql libraries


public class Demo extends JFrame {


    private final JTextArea textArea;  //defines the text area plot

    public Demo() {

        setTitle("Database Viewer");

        setSize(500, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // Create components				// creating 4 buttons

        JButton aec = new JButton("AEC");

        aec.setFocusable(false);

        JButton acet = new JButton("ACET");

        acet.setFocusable(false);

        JButton acoe = new JButton("ACOE");

        acoe.setFocusable(false);

        JButton all = new JButton("ALL");

        all.setFocusable(false);


        // textarea

        textArea = new JTextArea(10, 30);

        textArea.setBounds(100, 80, 600, 600);  // size of the text area

        textArea.setBorder(BorderFactory.createLineBorder(Color.black, 5, true)); // Add border

        textArea.setEditable(false);


        // Set layout

        setLayout(new FlowLayout());

        // Add components to the frame

        add(aec);
        add(acet);
        add(acoe);
        add(all);

        add(textArea);

        textArea.setEditable(false);



        // Add action listener to the button


        aec.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                String str = "aec";

                fetchDataFromDatabase(str,textArea);   //function to fetch from database with str

            }
        });


        acet.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String str = "acet";
                fetchDataFromDatabase(str,textArea);
            }
        });


        acoe.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "acoe";
                fetchDataFromDatabase(str,textArea);

            }
        });


        all.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String str = "all";

                fetchDataFromDatabase(str,textArea);
            }
        });
    }  // end of demo class



// fetch from db function

    private void fetchDataFromDatabase(String str ,JTextArea textArea) {


        // JDBC URL, username, and password of SQLite database

//connecting to the database

        String dbURL = "jdbc:mysql://localhost:3306/javaproject";
        String dbUser = "root";
        String dbPassword = "Ganesh@674";

        try {
            // Establish a connection

            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            // Create a statement


            Statement statement = connection.createStatement();





            ResultSet resultSet = switch (str) {



                case "aec" ->
                        statement.executeQuery("SELECT * FROM stddata WHERE COLLEGE='aec' ORDER BY CODEMIND DESC limit 10");
                case "acet" ->
                        statement.executeQuery("SELECT * FROM stddata  WHERE COLLEGE='acet' ORDER BY CODEMIND DESC limit 10");
                case "acoe" ->
                        statement.executeQuery("SELECT * FROM stddata  WHERE COLLEGE='acoe' ORDER BY CODEMIND DESC limit 10");
                case "all" -> statement.executeQuery("SELECT * FROM stddata  ORDER BY CODEMIND DESC limit 10 ");
                default -> null;

                // Execute a query to retrieve data from the databases

            };



            // Display the data in the text area


            textArea.setText("");


            // Clear previous content


            while (true) {

                assert resultSet != null;
                if (!resultSet.next()) break;

                int id = resultSet.getInt("ID");

                String name = resultSet.getString("NAME");

                String college = resultSet.getString("COLLEGE");

                String branch = resultSet.getString("BRANCH");

                int age = resultSet.getInt("AGE");

                String codemind = resultSet.getString("CODEMIND");

                textArea.append("ID: " + id + ", Name: " + name + ",College " + college + ", Branch: " + branch + ", Age: " + age + ", Codemind: " + codemind + "\n");

            }


            // Close resources

        }

        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR OCCURED"+e.getMessage());
        }
    }

    public static void main(String[] args) {


        // Create and show the GU
        Demo app = new Demo();
        app.setVisible(true);
}
}
