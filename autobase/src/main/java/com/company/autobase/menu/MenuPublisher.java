package com.company.autobase.menu;

import org.springframework.stereotype.Service;

@Service
public class MenuPublisher {
    public static void printMenu() {
        System.out.println("  1. Show vehicles;");
        System.out.println("  2. Show drivers;");
        System.out.println("  3. Add vehicle;");
        System.out.println("  4. Add drivers;");
        System.out.println("  5. Exit;");
        System.out.print(" Enter choice: ");
    }
}
