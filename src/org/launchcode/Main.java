package org.launchcode;

import org.launchcode.comparators.NameComparator;
import org.launchcode.comparators.PopulationComparator;
import org.launchcode.comparators.StateComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<City> cities = CityData.loadData();
        Comparator<? super City> comparator;

        // TODO - Use different comparators here
        Scanner in = new Scanner(System.in);
        System.out.println("would you like to organize by name(1), state(2), population(3), or square miles(4)?");
        int choice = in.nextInt();

        if (choice == 1) {
            comparator = new NameComparator();
        }else if (choice == 2) {
            comparator = new StateComparator();
        }else if (choice == 3){
            comparator = new PopulationComparator();
        }else{
            System.out.println("Not implemented yet");
            comparator = new NameComparator();
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
