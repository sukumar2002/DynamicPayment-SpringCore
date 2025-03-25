package com.Main.SpringCore;

import com.Payment.core.PaymentType;
import com.Payment.strategy.PaymentContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class PaymentApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.payment");
        PaymentContext paymentContext = context.getBean(PaymentContext.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display payment options
            System.out.println("\nSelect Payment Method:");
            for (PaymentType type : PaymentType.values()) {
                System.out.println(type.ordinal() + 1 + ". " + type.name());
            }
            System.out.println("0. Exit");

            // Get user choice
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Exit condition
            if (choice == 0) {
                System.out.println("Exiting... Thank you for using our payment system!");
                break;
            }

            // Validate choice
            if (choice < 1 || choice > PaymentType.values().length) {
                System.out.println("Invalid choice! Please select a valid payment method.");
                continue;
            }

            // Get selected payment type
            PaymentType selectedType = PaymentType.values()[choice - 1];

            // Get amount
            System.out.print("Enter the payment amount: ₹");
            double amount = scanner.nextDouble();

            // Validate amount
            if (amount <= 0) {
                System.out.println("Invalid amount! Please enter an amount greater than zero.");
                continue;
            }

            // Execute payment
            System.out.println(paymentContext.executePayment(selectedType, amount));

            // Show transaction history
            System.out.println("\nTransaction History:");
            paymentContext.showTransactionHistory();
        }

        scanner.close();
    }
}
