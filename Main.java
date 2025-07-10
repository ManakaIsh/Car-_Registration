package com.cars;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);


        Collection<Car> cars = new ArrayList<Car>(); //store cars after registration
//menu list  display
        System.out.println("Welcome to Car registration app ");
        System.out.println("select option:\n"+
                            "(1) register car\n"+
                            "(2) view report\n"+
                            "(3) find car by owner's name or plate number\n"+
                            "(4) exit app");

        int menuOps = input.nextInt();  //user selection

        while((menuOps == 1) || (menuOps == 2) || (menuOps == 3)){


            if (menuOps == 1){
                Car carObj = new Car();
                String make;
                String model;
                String vin;
                String plateNumber = "";
                int year;
                String ownerName;
                String ownSurname;
                int millage;

                System.out.println("Enter make");
                make = input.next();

                System.out.println("Enter model");
                model= input.next();

                System.out.println("Enter Vin");
                vin = input.next();
                while(!(vin.length() == 17)){
                    System.out.println("Enter valid vin number with 17 characters");
                    vin = input.next();
                }

                System.out.println("Enter owner's name");
                ownerName = input.next();

                System.out.println("Enter owner's Surname");
                ownSurname = input.next();

                System.out.println("Please select 1 for old format(ABC123GP) or 2 for new format plate number(AB12CDGP)");
                int plateChoice = input.nextInt();
                if(plateChoice == 1) {
                    System.out.println("Enter plate number e.g ABC123GP");
                    plateNumber = input.next();
                }else if(plateChoice == 2) {
                    System.out.println("Enter plate number e.g AB12CDGP");
                    plateNumber = input.next();
                }

                System.out.println("Enter millage");
                millage = input.nextInt();

                System.out.println("Enter Year");
                year = input.nextInt();

                carObj.setMake(make);
                carObj.setModel(model);
                carObj.setPlateNumber(plateNumber);
                carObj.setVin(vin);
                carObj.setYear(year);
                carObj.setMillage(millage);
                carObj.setOwnerName(ownerName);
                carObj.setOwnSurname(ownSurname);

                cars.add(carObj);
            } else if(menuOps == 2) {
                if (cars.isEmpty()) {
                    System.out.println("there are no cars captured");
                } else {
                    System.out.println("*********************  VEHICLES REPORT  ***********************");
                    System.out.println("There are " + cars.size() + " registered at the moment");
                    for (Car carObj : cars) {
                        int count=1;
                        System.out.print(count++);
                        System.out.println("MAKE: " + carObj.getMake() +
                                "\nMODEL: " + carObj.getModel() +
                                "\nPLATE NUMBER: " + carObj.getPlateNumber() +
                                "\nVIN NUMBER: " + carObj.getVin() +
                                "\nOWNER NAME: " + carObj.getOwnerName() +
                                "\nOWNER SURNAME: " + carObj.getOwnSurname() +
                                "\nYEAR: " + carObj.getYear() +
                                "\nMILLAGE: " + carObj.getMillage());
                        System.out.println("____________________________________");
                    }
                }

            }else if (menuOps == 3){
                System.out.println("Please select 1 to search by owner name or 2 for car plate number");
                int searchChoice = input.nextInt();     //user input to select what to search with
                if(searchChoice == 1) {
                    System.out.println("Enter owner name");
                    String searchName = input.next();
                    if (cars.isEmpty()) {
                        System.out.println("There are no cars registered");
                    }
                    for (Car carObj : cars) {
                        if (searchName.equalsIgnoreCase(carObj.getOwnerName())) {
                            System.out.println("MAKE: " + carObj.getOwnerName() +
                                    "\nMODEL: " + carObj.getModel() +
                                    "\nPLATE NUMBER: " + carObj.getPlateNumber() +
                                    "\nVIN NUMBER: " + carObj.getVin() +
                                    "\nOWNER NAME: " + carObj.getMake() +
                                    "\nOWNER SURNAME: " + carObj.getOwnSurname() +
                                    "\nYEAR: " + carObj.getYear() +
                                    "\nMILLAGE: " + carObj.getMillage());
                        }else {
                            System.out.println("Car does not exits");
                        }
                    }
                }else if(searchChoice == 2) {
                    System.out.println("Enter plate number e.g AB12CDGP");
                    String searchPlate = input.next();      //user input to select what to search with
                    if (cars.isEmpty()) {
                        System.out.println("There are no cars registered");
                    }
                        for (Car carObj : cars){
                            if(searchPlate.equalsIgnoreCase(carObj.getPlateNumber())){
                                System.out.println("MAKE: " + carObj.getPlateNumber() +
                                        "\nMODEL: " + carObj.getModel() +
                                        "\nPLATE NUMBER: " + carObj.getMake() +
                                        "\nVIN NUMBER: " + carObj.getVin() +
                                        "\nOWNER NAME: " + carObj.getOwnerName() +
                                        "\nOWNER SURNAME: " + carObj.getOwnSurname() +
                                        "\nYEAR: " + carObj.getYear() +
                                        "\nMILLAGE: " + carObj.getMillage());
                            }else{
                            System.out.println("Car does not exits");
                            }
                        }
                    }
                }

            System.out.println("select option:\n"+
                                "(1) register car\n"+
                                "(2) view report\n"+
                                "(3) find car by owner's name or plate number\n"+
                                "(4) exit app");
                menuOps = input.nextInt();
        }
        System.out.println("thanks for using the application");
    }
}
