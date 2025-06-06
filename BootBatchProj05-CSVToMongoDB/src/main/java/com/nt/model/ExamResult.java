//ExamResult.java(01.06.2025)
package com.nt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class ExamResult {
	@Id
       private Integer id;
       private String dob;
       private Float percentage;
       private Integer semester;
}
