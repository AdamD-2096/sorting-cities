package org.launchcode.comparators;

import org.launchcode.City;

import java.util.Comparator;

public class StateThenArea implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        int i = o1.getState().compareTo(o2.getState());
        if (i == 0){
            if (o1.getArea() > o2.getArea()){
                i = 1;
            }else if (o1.getArea() < o2.getArea()){
                i = -1;
            }else{
                i = 0;
            }
        }
        return i;
    }
}
