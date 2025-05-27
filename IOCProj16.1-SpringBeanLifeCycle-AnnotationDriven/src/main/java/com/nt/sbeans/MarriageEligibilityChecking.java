//AppConfig.java(30.01.2025)
package com.nt.sbeans;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("mec")
public class MarriageEligibilityChecking {
    @Value("${marriage.name}")
    private String name;
    @Value("${marriage.age}")
    private float age;
    @Value("${marriage.gender}")
    private String gender;
    @Value("${marriage.verifiedBy}")
    private String verifiedBy;
    private LocalDateTime verifiedOn;

    static {
        System.out.println("MarriageEligibilityChecking: Static Block");
    }

    public MarriageEligibilityChecking() {
        System.out.println("MarriageEligibilityChecking:: 0-Param Constructor");
    }

    @PostConstruct
    public void myInit() {
        System.out.println("MarriageEligibilityChecking.MyInit()");
        // Initialize Left Over Properties
        verifiedOn = LocalDateTime.now();
        // Check Whether Important Properties Are Injected With Correct Values Or Not
        if (age <= 0 || name == null)
            throw new IllegalArgumentException("Invalid Inputs For Name, Age");
    }

    // Business Method
    public String checkMarriageEligibility() {
        System.out.println("MarriageEligibilityChecking.CheckMarriageEligibility()");
        if (("Male".equalsIgnoreCase(gender) && age >= 21) || ("Female".equalsIgnoreCase(gender) && age >= 18)) {
            return "Mr/Miss/Mrs." + name + " You Are Eligible For Marriage, Verified By-" + verifiedBy + " VerifiedOn::" + verifiedOn;
        } else {
            return "Mr/Miss/Mrs." + name + " You Are Not Eligible For Marriage, Verified By-" + verifiedBy + " VerifiedOn::" + verifiedOn;
        }
    }
    @PreDestroy
    public void myDestroy() {
        System.out.println("MarriageEligibilityChecking.MyDestroy()");
        // Nullify Spring Bean Properties
        name = null;
        age = 0;
        verifiedBy = null;
        verifiedOn = null;
    }
}
