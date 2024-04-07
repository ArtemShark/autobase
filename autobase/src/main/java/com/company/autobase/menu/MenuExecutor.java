package com.company.autobase.menu;

import com.company.autobase.model.*;
import com.company.autobase.services.cargo_orders_service.CargoOrdersService;
import com.company.autobase.services.vehicle_service.VehicleService;
import com.company.autobase.services.shipment_types_service.ShipmentTypeService;
import com.company.autobase.services.driver_info_service.DriverInfoService;
import com.company.autobase.services.travel_routes_service.TravelRouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class MenuExecutor {
    private final VehicleService vehicleService;
    private final ShipmentTypeService shipmentTypeService;
    private final CargoOrdersService cargoOrdersService;
    private final TravelRouteService travelRouteService;
    private final DriverInfoService driverInfoService;

    final Scanner SCANNER = new Scanner(System.in);

    public void printMenu() {

        while (true) {
            try {
                MenuPublisher.printMenu();
                final int CHOICE = SCANNER.nextInt();
                SCANNER.nextLine();

                switch (CHOICE) {
                    case 1:
                        showVehicles();
                        break;
                    case 2:
                        showDrivers();
                        break;
                    case 3:
                        showCargoOrders();
                        break;
                    case 4:
                        addVehicle();
                        break;
                    case 5:
                        addDriver();
                        break;
                    case 6:
                        addCargoOrders();
                        break;
                    case 7:
                        assignCargoOrderToDriver();
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        throw new InputMismatchException();
                }
            }
            catch (InputMismatchException e) {
                log.warn(" Invalid number");
            }
        }
    }

    public void addVehicle() {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();

        System.out.print(" Enter producer: ");
        vehicle.setProducer(scanner.nextLine());
        System.out.print(" Enter do: ");
        vehicle.setModel_name(scanner.nextLine());
        System.out.print(" Enter vehicle state: ");
        vehicle.setVehicle_state(scanner.nextInt());
        System.out.print(" Enter cargo capacity: ");
        vehicle.setCargo_capacity(scanner.nextDouble());

        if(vehicleService.save(vehicle).getId() != null) {
            System.out.println(" Car " + vehicle.getModel_name() + " added");
        }
        else {
            log.warn(" Cannot add vehicle!");
            log.warn(vehicle);
        }
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
        driverInfo.setDriver_experience(scanner.nextDouble());

        if(driverInfoService.save(driverInfo).getId() != null) {
            System.out.println(" Driver " + driverInfo.getFirstName() + " " + driverInfo.getLastName() + " added");
        }
        else {
            log.warn(" Cannot add driver");
            log.warn(driverInfo);
        }
    }

    public void addCargoOrders() {
        long id;
        Scanner scanner = new Scanner(System.in);
        CargoOrders cargoOrders = new CargoOrders();
        List<ShipmentType> shipmentTypes = shipmentTypeService.find();

        System.out.print(" Enter shipment weight: ");
        cargoOrders.setTotal_weight(scanner.nextDouble());
        System.out.println("\n Select shipment type:");
        shipmentTypes.forEach(System.out::println);

        id = getValidId(shipmentTypes.stream().map(ShipmentType::getId).collect(Collectors.toList()), " Enter shipment type Id to add: ");
        cargoOrders.setShipmentType(shipmentTypeService.findShipmentTypeById(id));

        if (cargoOrdersService.save(cargoOrders).getId() != null) {
            System.out.println(" Cargo order added");
        }
        else {
            System.out.println(" Cannot add cargo order");
            System.out.println(cargoOrders);
        }
    }

    public void showDrivers() {
        print(" All drivers:", "=", driverInfoService.find());
    }

    public void showVehicles() {
        print(" All vehicles:", "=", vehicleService.find());
    }

    public void showCargoOrders() {
        print(" All cargo orders:", "=", cargoOrdersService.find());
    }

    public void assignCargoOrderToDriver() {
        List<Vehicle> vehicles = vehicleService.find();
        List<TravelRoute> travelRoutes = travelRouteService.find();
        List<DriverInfo> driverInfo = driverInfoService.find();
        List<CargoOrders> cargoOrders = cargoOrdersService.find();

        for (CargoOrders cargoOrder : cargoOrders) {
            TravelRoute travelRoute = getRoute(cargoOrder, driverInfo, vehicles, travelRoutes);

            if(!travelRoutes.contains(travelRoute)) {
                travelRouteService.save(travelRoute);
                travelRoutes.add(travelRoute);
            }

        }
    }

    private static TravelRoute getRoute(CargoOrders cargoOrder, List<DriverInfo> driverInfos, List<Vehicle> vehicles, List<TravelRoute> travelRoutes) {
        TravelRoute travelRoute = new TravelRoute();

        for (DriverInfo driverInfo : driverInfos) {
            if (driverInfo.getDriver_experience() >= cargoOrder.getShipmentType().getExperience() && !isDriverOnRoute(travelRoutes, driverInfo)) {
                travelRoute.setDriverInfo(driverInfo);
                break;
            }
        }

        for (Vehicle vehicle : vehicles) {
            if(vehicle.getCargo_capacity() >= cargoOrder.getTotal_weight() && !isCarOnRoute(travelRoutes, vehicle)) {
                travelRoute.setVehicle(vehicle);
                break;
            }
        }

        travelRoute.setCargoOrders(cargoOrder);
        return travelRoute;
    }

    private static boolean isDriverOnRoute(List<TravelRoute> travelRoutes, DriverInfo driverInfo) {
        for (TravelRoute travelRoute : travelRoutes) {
            if (travelRoute.getDriverInfo().getId().equals(driverInfo.getId())) {
                return true;
            }
        }

        return false;
    }

    private static boolean isCarOnRoute(List<TravelRoute> travelRoutes, Vehicle vehicle) {
        for (TravelRoute travelRoute : travelRoutes) {
            if (travelRoute.getVehicle().getId().equals(vehicle.getId())) {
                return true;
            }
        }

        return false;
    }

    private static long getValidId(List<Long> longList, String mess) {
        Scanner scanner = new Scanner(System.in);
        long id;

        while (true) {
            try {
                System.out.print(mess);
                id = scanner.nextLong();
                scanner.nextLine();

                if (longList.contains(id)) {
                    return id;
                }
                else {
                    throw new RuntimeException(" Incorrect Id");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Enter a correct number");
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
}
