package com.techno.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techno.mapping.entity.Capability;

public interface CapabilityRepo extends JpaRepository<Capability, Long> {

	Capability findByCapabilities(Object cap);
}
