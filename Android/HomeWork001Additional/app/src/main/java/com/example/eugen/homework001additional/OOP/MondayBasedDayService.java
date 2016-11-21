package com.example.eugen.homework001additional.OOP;

import com.example.eugen.homework001additional.EnumSample.DayOfWeek;

/**
 * Created by Eugen on 21.11.2016.
 */

public abstract class MondayBasedDayService implements IDayService {
    @Override
    public DayOfWeek GetFirstDay() {
        return DayOfWeek.MONDAY;
    }

    @Override
    public DayOfWeek[] GetWeekSequence() {
        return DayOfWeek.values();
    }

    @Override
    public abstract boolean AcceptWinterTime();
}
