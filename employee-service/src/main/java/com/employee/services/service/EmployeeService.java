package com.employee.services.service;
import java.util.List;
import java.util.Optional;

//https://www.geeksforgeeks.org/spring-boot-microservices-communication-using-resttemplate-with-example/?ref=ml_lbp
//https://www.geeksforgeeks.org/spring-boot-microservices-communication-using-webclient-with-example/?ref=ml_lbpimport java.util.Optional;
//https://www.geeksforgeeks.org/spring-boot-microservices-communication-using-feignclient-with-example/?ref=ml_lbp

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
//import com.netflix.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.services.entity.Employee;
import com.employee.services.repository.AddressClient;
import com.employee.services.repository.EmployeeRepo;
import com.employee.services.response.AddressResponse;
import com.employee.services.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepo employeeRepo;
 
    @Autowired
    private ModelMapper mapper;
    
    @Autowired
    DiscoveryClient discoveryClient;
    
    @Autowired
    LoadBalancerClient loadBalancerClient;
    
    @Autowired
    RestTemplate restTemplate;
  
// Alternative of create bean for RestTemplate.
    
//	public EmployeeService(@Value("${addressservice.base.url}") String addressBaseUrl, RestTemplateBuilder builder) {
//		System.out.println(addressBaseUrl);
//		this.restTemplate = builder.rootUri(addressBaseUrl).build();
//	}
    
// RestTemplate: It is blocking synchronous call in nature. It will block the execution of next line till the response get back.
// To overcome please use web-client
// jars : spring-boot-starter-web

/*
    public EmployeeResponse getEmployeeById(int id) {
    	    	
    	// db call
        Optional<Employee> employee = employeeRepo.findById(id);
        
        // rest call
        AddressResponse addressResponse=new AddressResponse();
//        addressResponse = restTemplate.getForObject("http://localhost:8081/address-service/address/"+id, AddressResponse.class, id);  
        addressResponse = restTemplate.getForObject("/address/{id}", AddressResponse.class, id);        
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
    
*/
/*   
    public EmployeeResponse getEmployeeById(int id) {
    	
    	// db call
        Optional<Employee> employee = employeeRepo.findById(id);
        
        // Using Discovery client:
        // Get the details of ip and port no from ADDRESS-SERVICE which is available in Discovery Service client.
        AddressResponse addressResponse=new AddressResponse();
        
//        List<ServiceInstance> instances= discoveryClient.getInstances("address-service");
//        ServiceInstance serviceInstance =  instances.get(0);
//        String uri= serviceInstance.getUri().toString();
        
        // Using LoadBalancerClient: To distributed equal load on various server.\
        String uri =loadBalancerClient.choose("address-service").getUri().toString();
        
        System.out.println("Uri >>>>> "+ uri);
        
        addressResponse = restTemplate.getForObject(uri+"/address-service/address/{id}", AddressResponse.class, id);

        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
    
*/
    
/*
    
// WebClient: It is asynchronous non-blocking in nature for call external services.
// jars : spring-boot-starter-webflux
  
    WebClient webclient;
    
	public EmployeeService(@Value("${addressservice.base.url}") String addressBaseUrl) {
		this.webclient= WebClient.builder()
				.baseUrl(addressBaseUrl)
				.build();
	}
 
    public EmployeeResponse getEmployeeById(int id) {
    	
    	// db call
        Employee employee = employeeRepo.findById(id).get();
        
        // rest call
        AddressResponse addressResponse=new AddressResponse();
        addressResponse = webclient.get()
        		.uri("/address/"+id)
        		.retrieve()
        		.bodyToMono(AddressResponse.class)
        		.block();    
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
        employeeResponse.setAddressResponse(addressResponse);
        
        return employeeResponse;
    }
    
*/
 
// FeignClient : FeignClient also known as Spring Cloud OpenFeign is a Declarative REST Client in Spring Boot Web Application


    @Autowired
    private AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int id) {
    
    	// db call
        Employee employee = employeeRepo.findById(id).get();
        
        // Using FeignClient
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
         employeeResponse.setAddressResponse(addressResponse.getBody());

        return employeeResponse;
    }  

    
    
    
}
