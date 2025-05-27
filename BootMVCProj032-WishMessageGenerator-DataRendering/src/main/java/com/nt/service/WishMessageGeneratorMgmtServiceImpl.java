//WishMessageGeneratorMgmtServiceImpl.java(29.03.2025)
package com.nt.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageGeneratorMgmtServiceImpl implements IWishMessageGeneratorMgmtService {

	@Override
    public String generateWishMessage() {
        // Business Logic to generate a wish message based on the current time
        // Get current system time
        LocalTime time = LocalTime.now();
        int hour = time.getHour();

        // Generate wish message based on time
        if (hour >= 5 && hour < 12)
            return "Good Morning";
        else if (hour >= 12 && hour < 17)
            return "Good Afternoon";
        else if (hour >= 17 && hour < 21)
            return "Good Evening";
        else
            return "Good Night";
    }
}
