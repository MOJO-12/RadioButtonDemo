import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonDemo extends JFrame implements ActionListener {
    
    // Declare Variables
    JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    JLabel imageLabel;
    JPanel radioPanel;
    
    // Image scale
    ImageIcon birdIcon = new ImageIcon(new ImageIcon("images/bird.jpg").getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH));
    ImageIcon catIcon = new ImageIcon(new ImageIcon("images/cat.jpg").getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH));
    ImageIcon dogIcon = new ImageIcon(new ImageIcon("images/dog.jpg").getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH));
    ImageIcon rabbitIcon = new ImageIcon(new ImageIcon("images/rabbit.jpg").getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH));
    ImageIcon pigIcon = new ImageIcon(new ImageIcon("images/pig.jpg").getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH));

    // Panel for radio buttons
    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 360);
        setLayout(new BorderLayout());

        radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        radioPanel.add(Box.createVerticalStrut(30));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        add(radioPanel, BorderLayout.WEST);

        pigButton.setSelected(true);
        imageLabel = new JLabel(pigIcon);
        add(imageLabel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    // Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPet = "";
        
        if (birdButton.isSelected()) {
            imageLabel.setIcon(birdIcon);
            selectedPet = "Bird";
        } else if (catButton.isSelected()) {
            imageLabel.setIcon(catIcon);
            selectedPet = "Cat";
        } else if (dogButton.isSelected()) {
            imageLabel.setIcon(dogIcon);
            selectedPet = "Dog";
        } else if (rabbitButton.isSelected()) {
            imageLabel.setIcon(rabbitIcon);
            selectedPet = "Rabbit";
        } else if (pigButton.isSelected()) {
            imageLabel.setIcon(pigIcon);
            selectedPet = "Pig";
        }

        JOptionPane.showMessageDialog(this, "You selected: " + selectedPet);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RadioButtonDemo().setVisible(true);
        });
    }
}