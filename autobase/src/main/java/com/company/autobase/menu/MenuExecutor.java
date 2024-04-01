package com.company.autobase.menu;

import com.company.autobase.AppStarter;
import com.company.autobase.dao.drivers_infoDAO.DriverInfoDao;
import com.company.autobase.dao.vehicleDAO.VehicleDao;
import com.company.autobase.model.DriverInfo;
import com.company.autobase.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class MenuExecutor {
    @Autowired
    private DriverInfoDao driverInfoDao;

    @Autowired
    private VehicleDao vehicleDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);
    final Scanner SCANNER = new Scanner(System.in);
    public void printMenu() {
        while (true) {
            try {
                MenuPublisher.printMenu();
                int choice = SCANNER.nextInt();
                SCANNER.nextLine();

                switch (choice) {
                    case 1:
                        showVehicles();
                        break;
                    case 2:
                        showDrivers();
                        break;
                    case 3:
                        addVehicle();
                        break;
                    case 4:
                        addDriver();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        throw new InputMismatchException();
                }
            }
            catch (InputMismatchException e) {
                LOGGER.warn(" Invalid number input!");
            }
        }
    }

    private void print(String mess, String sep, List<?> l) {
        System.out.println();
        for (int i = 0; i < 15; i++) {
            System.out.print(sep);
        }
        System.out.println();
        System.out.println(mess);
        for (Object item : l) {
            System.out.println(item);
        }
        for (int i = 0; i < 15; i++) {
            System.out.print(sep);
        }
        System.out.println();
    }


    public void showVehicles() {
        print(" All vehicles:", "-", vehicleDao.find());
    }

    public void showDrivers() {
        print(" All drivers:", "-", driverInfoDao.find());
    }

    public void addDriver() {
        Scanner scanner = new Scanner(System.in);
        DriverInfo driverInfo = new DriverInfo();

        System.out.print(" Enter first name: ");
        driverInfo.setFirstName(scanner.nextLine());
        System.out.print(" Enter last name: ");
        driverInfo.setLastName(scanner.nextLine());

        System.out.print(" Enter payment: ");
        driverInfo.setPayment(scanner.nextBigDecimal());
        System.out.print(" Enter driver experience: ");
        driverInfo.setDriverExperience(scanner.nextDouble());

        if(driverInfoDao.save(driverInfo) > 0) {
            System.out.println(" Driver " + driverInfo.getLastName() + " " + driverInfo.getFirstName() + " added");
        }
        else {
            System.out.println(" Can't add this driver!");
        }

    }

    public void addVehicle() {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();

        System.out.print(" Enter producer: ");
        vehicle.setProducer(scanner.nextLine());
        System.out.print(" Enter model: ");
        vehicle.setModelName(scanner.nextLine());
        System.out.print(" Enter vehicle state: ");
        vehicle.setVehicleState(scanner.nextInt());
        System.out.print(" Enter cargo capacity: ");
        vehicle.setCargoCapacity(scanner.nextDouble());

        if(vehicleDao.save(vehicle) > 0) {
            System.out.println(" Vehicle " + vehicle.getModelName() + " added");
        }
        else {
            System.out.println(" Can't add this vehicle!");
        }

    }
}

