package com.BloodStream.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BloodStream.pojos.BloodBank;

@Repository
public interface BankRepository extends JpaRepository<BloodBank, Long> {

	Optional<BloodBank> findByName(String bankName);
	
	List<BloodBank> findAll();
	
	Optional<BloodBank> findByUserId(Long id);
}
