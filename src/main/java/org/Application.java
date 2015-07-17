package org;

import java.util.Map;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.cloud.client.discovery.DiscoveryClient;

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
	  for (InstanceInfo instance : discoveryClient.getInstancesByVipAddressAndAppName(null,eurekaName,false)) {
		  //ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		  String host = instance.getHostName();
		  String id = instance.getId();
		  int port = instance.getPort();
		  Map<String,String> metadata = instance.getMetadata();
		  

		  result +=id+"==>"+host+":"+port+":==>"+metadata.get("foobar")+"*******";
	  }
	  return result;
		  
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}

