package com.example.eugen.homework001additional.OOP;

import com.example.eugen.homework001additional.EnumSample.DayOfWeek;

/**
 * Created by Eugen on 21.11.2016.
 */

public interface IDayService {
    DayOfWeek GetFirstDay();

    DayOfWeek[] GetWeekSequence();

    boolean AcceptWinterTime();
}
