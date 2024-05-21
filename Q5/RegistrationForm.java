import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {
    private JTextField firstNameField, lastNameField, fatherNameField, motherNameField, ageField, phoneNumberField;
    private JComboBox<String> courseComboBox;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JTextArea addressTextArea;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        fatherNameField = new JTextField(20);
        motherNameField = new JTextField(20);
        ageField = new JTextField(5);
        phoneNumberField = new JTextField(15);

        courseComboBox = new JComboBox<>(new String[]{"Select Course", "Java", "Python", "JavaScript", "C++", "Other"});

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        addressTextArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(addressTextArea);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMessage("Submitted Successfully");
            }
        });

        // Set layout to GridLayout
        setLayout(new GridLayout(12, 2));

        // Add components to the frame
        add(new JLabel("First Name:"));
        add(firstNameField);

        add(new JLabel("Last Name:"));
        add(lastNameField);

        add(new JLabel("Father's Name:"));
        add(fatherNameField);

        add(new JLabel("Mother's Name:"));
        add(motherNameField);

        add(new JLabel("Age:"));
        add(ageField);

        add(new JLabel("Gender:"));
        add(maleRadioButton);
        add(new JLabel(""));
        add(femaleRadioButton);

        add(new JLabel("Course:"));
        add(courseComboBox);

        add(new JLabel("Address:"));
        add(scrollPane);

        add(new JLabel("Phone Number:"));
        add(phoneNumberField);

        add(submitButton);

        setVisible(true);
    }

    private void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationForm();
            }
        });
    }
}
