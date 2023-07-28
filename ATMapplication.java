import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMapplication extends JFrame {

    private double balance = 1000.0; // Starting balance

    private JLabel balanceLabel;
    private JTextField amountField;
    private JTextArea transactionArea;

    public ATMapplication() {
        setTitle("ATM Machine");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        balanceLabel = new JLabel("Balance: ₹" + balance);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 20));

        amountField = new JTextField(10);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));

        transactionArea = new JTextArea(10, 30);
        transactionArea.setEditable(false);
        transactionArea.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performWithdraw();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDeposit();
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBalance();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(new JLabel("Welcome to the ATM Machine"));
        panel.add(new JLabel());

        panel.add(balanceLabel);
        panel.add(new JLabel());

        panel.add(new JLabel("Enter Amount: "));
        panel.add(amountField);

        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(checkBalanceButton);
        panel.add(new JLabel());

        JScrollPane scrollPane = new JScrollPane(transactionArea);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void performWithdraw() {
        String amountText = amountField.getText();
        try {
            double amount = Double.parseDouble(amountText);
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                updateBalanceLabel();
                updateTransactionArea("Withdraw: ₹" + amount);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid amount or insufficient balance!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid amount.");
        }
    }

    private void performDeposit() {
        String amountText = amountField.getText();
        try {
            double amount = Double.parseDouble(amountText);
            if (amount > 0) {
                balance += amount;
                updateBalanceLabel();
                updateTransactionArea("Deposit: ₹" + amount);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid amount!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid amount.");
        }

    }

    private void showBalance() {
        JOptionPane.showMessageDialog(this, "Current Balance: ₹" + balance);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: ₹" + balance);
    }

    private void updateTransactionArea(String transaction) {
        transactionArea.append(transaction + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMapplication().setVisible(true);
            }
        });
    }
}