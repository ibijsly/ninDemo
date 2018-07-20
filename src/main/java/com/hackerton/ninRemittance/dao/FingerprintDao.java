package com.hackerton.ninRemittance.dao;

import com.hackerton.ninRemittance.model.Fingerprint;
import com.hackerton.ninRemittance.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FingerprintDao extends JpaRepository<Fingerprint, Long> {
    public Fingerprint findByUserDetails(UserDetails userDetails);
}
