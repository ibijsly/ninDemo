package com.hackerton.ninRemittance.dao;

import com.hackerton.ninRemittance.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsDao extends JpaRepository<UserDetails, Long> {

    public UserDetails findByPhoneAndEmail(String phone, String email);
    public UserDetails findByNin(String nin);
    public UserDetails findByVin(String vin);

}
