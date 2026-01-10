package com.parcel_management_system.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcel_management_system.app.entity.CustomerProfile;

@Repository
public interface CustomerReopository extends JpaRepository<CustomerProfile, Long> {
}
