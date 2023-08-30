package com.BloodStream.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BloodStream.pojos.RegisterForCamp;

public interface ICampRegRepo extends JpaRepository<RegisterForCamp, Long> {

}
