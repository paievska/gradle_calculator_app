package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;
    JLabel preview;
    Font myFont = new Font("Bold font", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    CalculatorLogic cl = new CalculatorLogic();
    String currentInput = "";

    Calculator() {
        initializeUI();
        setTextField();
        setButtons();
        setPanel();
        preview = new JLabel();
        preview.setFont(new Font("Preview", Font.ITALIC, 15));
        preview.setForeground(new Color(150, 150, 150));
        preview.setBounds(40, 5, 200, 15);
        frame.add(preview);
        frame.add(textField);
        frame.add(delButton);
        frame.add(panel);
        frame.add(equButton);
        frame.setVisible(true);
    }

    public void initializeUI() {
        frame = new JFrame("org.example.Calculator");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/calculator.png")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setResizable(false);
    }

    public void setTextField() {
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
    }

    public void setButtons() {
        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("*");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton();
        delButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/clear_30x30.png"))));
        delButton.setBorder(BorderFactory.createEmptyBorder());
        delButton.setContentAreaFilled(false);
        clrButton = new JButton("C");
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = divButton;
        functionButtons[3] = mulButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(new Color(248, 204, 147));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(253, 200, 210));
        }
        delButton.setBounds(320, 80, 30, 30);
        equButton.setBounds(290, 430, 60, 60);
        equButton.setBackground(new Color(232, 114, 211));
    }

    public void setPanel() {
        panel = new JPanel();
        panel.setBounds(50, 120, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(clrButton);
        panel.add(divButton);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
                currentInput += String.valueOf(i);
            }
            preview.setText(currentInput);
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
            currentInput += ".";
            preview.setText(currentInput);
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            currentInput += "+";
            preview.setText(currentInput);
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            currentInput += "-";
            preview.setText(currentInput);
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            currentInput += "*";
            preview.setText(currentInput);
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            currentInput += "/";
            preview.setText(currentInput);
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            currentInput += "=";
            preview.setText(currentInput);

            switch (operator) {
                case '+':
                    result = cl.sumNumbers(num1, num2);
                    break;
                case '-':
                    result = cl.subNumbers(num1, num2);
                    break;
                case '*':
                    result = cl.mulNumbers(num1, num2);
                    break;
                case '/':
                    result = cl.divNumbers(num1, num2);
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
            currentInput = "";
            preview.setText(currentInput);
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
            for (int i = 0; i < currentInput.length() - 1; i++) {
                currentInput = "" + currentInput.charAt(i);
            }
            preview.setText(currentInput);
        }
    }
}