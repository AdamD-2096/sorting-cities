package org.launchcode;

import org.launchcode.comparators.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<City> cities = CityData.loadData();
        CompoundComparator comparator = new CompoundComparator();

        // TO done - Use different comparators here
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("would you like to organize by name(1), state(2), population(3), or square miles(4)?" +
                    "\n  done(0)" +
                    "\nselect one by typing tbe corresponding number and pushing enter.");
            int choice = in.nextInt();

            if (choice == 1) {
                comparator.add(new NameComparator());
            } else if (choice == 2) {
                comparator.add(new StateComparator());
            } else if (choice == 3) {
                comparator.add(new PopulationComparator());
            } else if (choice == 4) {
                comparator.add(new AreaComparator());
            }else{
                break;
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
