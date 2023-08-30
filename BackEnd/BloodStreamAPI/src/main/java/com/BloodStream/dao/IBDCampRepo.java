package com.BloodStream.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BloodStream.pojos.BDCamp;
@Repository
public interface IBDCampRepo extends JpaRepository<BDCamp, Long> {

}
