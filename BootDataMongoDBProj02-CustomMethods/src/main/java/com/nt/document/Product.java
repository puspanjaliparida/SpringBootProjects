//Product.java(24.05.2025)
package com.nt.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection="product")
@Data
public class Product {
	 @Id
     private String id;
     private String name;
     private String status;
     private Float price;
     private Float qty;
     private String company;
     private LocalDate expiryDate;
}
