package com.techno.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techno.mapping.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

//	Optional<List<Address>> findByIdIn(List<Long> ids);
}
