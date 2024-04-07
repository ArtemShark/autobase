package com.company.autobase.menu;

import org.springframework.stereotype.Service;

@Service
public class MenuPublisher {
    public static void printMenu() {
        System.out.println("  1. Show vehicles;");
        System.out.println("  2. Show drivers;");
        System.out.println("  3. Show cargo orders;");
        System.out.println("  4. Add vehicle;");
        System.out.println("  5. Add drivers;");
        System.out.println("  6. Add cargo orders;");
        System.out.println("  7. Assign cargo orders to driver;");
        System.out.println("  8. Exit;");
        System.out.print(" Enter choice: ");
    }
}
