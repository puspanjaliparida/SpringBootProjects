//MenuItemPrices.java(15.02.2025)
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component("menup")
@Data
public class MenuItemPrices {
       @Value("${menu.dosarate}")
       private Float dosaPrice;
       @Value("${menu.idlyrate}")
       private Float idlyPrice;
       @Value("${menu.poharate}")
       private Float pohaPrice;
       @Value("${menu.vprate}")
       private Float vadaPavPrice;
}
