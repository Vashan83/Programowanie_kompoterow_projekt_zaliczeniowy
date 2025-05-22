package rip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Background {
    public static void main(String[] args) {
        JFrame window = new JFrame("Moje okno");
        window.setSize(720, 480);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //zamykaj po nacisnieciu "X"
        window.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(26, 139, 30));
        panel.setLayout(new FlowLayout());  //uklad poziomy

        JLabel label = new JLabel("Podaj swoje imię:");
        label.setFont(new Font("Arial", Font.BOLD, 19));

        JTextField nameField = new JTextField(20);
        nameField.setBackground(new Color(0, 0, 0));
        nameField.setForeground(new Color(0, 250, 26));
        nameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        panel.add(label);
        panel.add(nameField);
        window.add(panel);

        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();

                if (!name.isEmpty()) {
                    JOptionPane.showMessageDialog(window, "Witaj, " + name + "!");
                    saveToFile(name);
                    nameField.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(window, "Nalezy podac imię!");
                }
            }
        });

        window.setVisible(true);
    }

    // Metoda zapisująca imię do pliku userNames.txt
    private static void saveToFile(String imie) {
        File file = new File("userNames.txt");

        try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(imie);
            bw.newLine();
        } catch (IOException ex) {
            System.err.println("Błąd podczas zapisu do pliku: " + ex.getMessage());
        }
    }
}