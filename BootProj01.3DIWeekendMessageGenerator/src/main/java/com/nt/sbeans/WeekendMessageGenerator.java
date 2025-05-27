//WeekendMessageGenerator.java(04.02.2025)
package com.nt.sbeans;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WeekendMessageGenerator {
    // Inject LocalDate Bean
    @Autowired
    private LocalDate ldate;

    // Business Method To Determine Message
    public String generateMessage() {
        DayOfWeek day = ldate.getDayOfWeek();

        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            return "Enjoy Your Weekend!";
        } else {
            return "Happy Working Hours!";
        }
    }
}
