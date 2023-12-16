package com.address.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.address.services.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

//	@Query(nativeQuery = true, value = "SELECT ea.id, ea.city, ea.state FROM gfgmicroservicesdemo.address ea join gfgmicroservicesdemo.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
	@Query(nativeQuery = true, value = "SELECT ea.id, ea.city, ea.state FROM mocroservicesdb.address ea join mocroservicesdb.employee e on e.id = ea.id where ea.id=:employeeId")
	Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
