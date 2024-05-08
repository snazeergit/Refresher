package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("provider-service")
public interface IConsumer_FeignClient {

	@GetMapping("provider/api/info")
	public ResponseEntity<String> getProviderInstance();

}