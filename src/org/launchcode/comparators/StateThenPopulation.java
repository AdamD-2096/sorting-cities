package org.launchcode.comparators;

import org.launchcode.City;

import java.util.Comparator;

public class StateThenPopulation implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        int i = o1.getState().compareTo(o2.getState());
        if (i == 0){
            i = o1.getPopulation() - o2.getPopulation();
        }
        return i;
    }
}
