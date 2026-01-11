package com.parcel_management_system.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcel_management_system.app.dto.response.CustomerHomePageResponseDto;
import com.parcel_management_system.app.dto.response.CustomerProfilePageResponseDto;
import com.parcel_management_system.app.entity.CustomerProfile;
import com.parcel_management_system.app.entity.User;
import com.parcel_management_system.app.exception.ResourceNotFound;
import com.parcel_management_system.app.repository.CustomerReopository;
import com.parcel_management_system.app.repository.UserRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerReopository customerReopository;

    @Autowired
    private UserRepository userRepository;

    public CustomerHomePageResponseDto getCustomerHomePageDetails(Long customerId) {
        User customer = userRepository.findById(customerId).orElseThrow(() -> new ResourceNotFound("Customer"));

        return new CustomerHomePageResponseDto(customerId, customer.getName(), 0, 0, 0, 0);
    }

    public CustomerProfilePageResponseDto getCustomerProfileDetails(Long customerId) {
        User customer = userRepository.findById(customerId).orElseThrow(() -> new ResourceNotFound("Customer"));
        CustomerProfile customerProfile = customerReopository.findByUserId(customerId)
                .orElseThrow(() -> new ResourceNotFound("Customer"));

        return new CustomerProfilePageResponseDto(
                customerId,
                customer.getName(),
                customer.getUsername(),
                customer.getRole(),
                customer.getEmail(),
                customerProfile.getMobileCountryCode(),
                customerProfile.getMobileNumber(),
                customerProfile.getAlternateMobileCountryCode(),
                customerProfile.getAlternateNumber(),
                customerProfile.getHouseNo(),
                customerProfile.getAddressLine1(),
                customerProfile.getAddressLine2(),
                customerProfile.getLandmark(),
                customerProfile.getCity(),
                customerProfile.getState(),
                customerProfile.getPinCode(),
                customerProfile.getCountry(),
                customerProfile.isPreferences());
    }
}
