package com.example.eugen.homework001additional.OOP;

import com.example.eugen.homework001additional.EnumSample.DayOfWeek;

/**
 * Created by Eugen on 21.11.2016.
 */

public class USADayService implements IDayService {
    @Override
    public DayOfWeek GetFirstDay() {
        return DayOfWeek.SUNDAY;
    }

    @Override
    public DayOfWeek[] GetWeekSequence() {
        return new DayOfWeek[]{
                DayOfWeek.SUNDAY,
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY,
                DayOfWeek.SATURDAY
        };
    }

    @Override
    public boolean AcceptWinterTime() {
        return false;
    }
}
