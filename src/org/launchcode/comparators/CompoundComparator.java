package org.launchcode.comparators;

import org.launchcode.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator implements Comparator<City> {
    List<Comparator<City>> comparators = new ArrayList<>();

    @Override
    public int compare(City o1, City o2){
        int num = 0;
        for (int i = 0; i < comparators.size(); i++){
            num = comparators.get(i).compare(o1, o2);
            if (num != 0){
                break;
            }
        }
        return num;
    }
    public void add(Comparator<City> comp){
        comparators.add(comp);
    }
}
