//BillingMSClientComp.java(20.05.2025)
package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("BillingMS")//Target MS Service id
public interface IBillingMSClientComp {
	 
	@GetMapping("/billing-api/bill")
	public ResponseEntity<String> invokeDoBilling();
}
