package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class Consumer_DiscoveryClient {

	@Autowired
	private DiscoveryClient client;
	@Autowired
	private RestTemplate template;

	public String getProviderInstance() {
		List<ServiceInstance> instancesList = client.getInstances("provider-service");
		ServiceInstance serviceInstance = instancesList.get(0);
		URI uri = serviceInstance.getUri();
		String url = uri + "/producer/api/info";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class);
		String responseBody = response.getBody();
		return responseBody;
	}
}
