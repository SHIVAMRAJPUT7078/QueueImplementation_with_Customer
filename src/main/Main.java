package main;

import definition.MaintainCustomer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaintainCustomer list = new MaintainCustomer();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" **************************************************** ");
            System.out.println("\t\tPress 1 to insert a customer");
            System.out.println("\t\tPress 2 to remove a customer");
            System.out.println("\t\tPress 3 to display first customer ");
            System.out.println("\t\tPress 4 to exit\n");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: {
                    System.out.println("Enter customer name");
                    String name = sc.nextLine();
                    list.addCustomer(name);
                    break;
                }
                case 2: {
                    list.removeCustomer();
                    break;
                }
                case 3: {
                    list.displayCustomer();
                    break;
                }
            }
            if (choice == 4) {
                break;
            }
        }

    }
}
