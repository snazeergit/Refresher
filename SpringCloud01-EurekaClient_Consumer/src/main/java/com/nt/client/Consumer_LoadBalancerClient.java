package com.nt.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class Consumer_LoadBalancerClient {

	@Autowired
	private RestTemplate template;
	@Autowired
	private LoadBalancerClient lBClient;

	public String getProviderInstance() {
		ServiceInstance serviceInstance = lBClient.choose("provider-service");
		URI uri = serviceInstance.getUri();
		String Url = uri + "/provider/api/info";
		ResponseEntity<String> response = template.exchange(Url, HttpMethod.GET, null, String.class);
		return response.getBody();
	}
}