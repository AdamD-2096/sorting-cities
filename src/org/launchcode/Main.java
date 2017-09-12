package org.launchcode;

import org.launchcode.comparators.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<City> cities = CityData.loadData();
        Comparator<? super City> comparator;

        // TO done - Use different comparators here
        Scanner in = new Scanner(System.in);
        System.out.println("would you like to organize by name(1), state(2), population(3), or square miles(4)?" +
                         "\n other options(0 or 5)" +
                         "\nselect one by typing tbe corresponding number and pushing enter.");
        int choice = in.nextInt();

        if (choice == 1) {
            comparator = new NameComparator();
        }else if (choice == 2) {
            comparator = new StateComparator();
        }else if (choice == 3){
            comparator = new PopulationComparator();
        }else if (choice == 4){
            comparator = new AreaComparator();
        }else{
            System.out.println("would you like to organize by state and population(1), or state and square miles(2)?" +
                    "\nselect one by typing tbe corresponding number and pushing enter.");
            choice = in.nextInt();
            if (choice == 1) {
                comparator = new StateThenPopulation();
            }else {
                comparator = new StateComparator();
            }
        }
        cities.sort(comparator);

        printCities(cities);

    }

    private static void printCities(ArrayList<City> cities) {

        System.out.println(City.getTableHeader());

        for(City c : cities) {
            System.out.println(c);
        }

    }
}
