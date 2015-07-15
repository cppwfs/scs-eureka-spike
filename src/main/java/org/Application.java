package org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class Application {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${spring.application.name}")
	String eurekaName;
	
	
  @RequestMapping("/")
  public String home() {
	  
	  String hostName;
	  String result = "";
	  for (ServiceInstance instance : discoveryClient.getInstances(eurekaName)) {
		  //ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		  String host = instance.getHost();
		  String id = instance.getServiceId();
		  int port = instance.getPort();
		  result +=id+"==>"+host+":"+port+"\n";
	  }
	  return result;
		  
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}

