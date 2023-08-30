package com.BloodStream.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BloodStream.enums.Antigens;
import com.BloodStream.enums.BloodTypes;
import com.BloodStream.pojos.BloodBank;
import com.BloodStream.pojos.BloodRepository;
import com.BloodStream.pojos.BloodRepositoryID;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodRepository, BloodRepositoryID> {
  /**
   * Find list of bloods available in repository by blood type and antigen.
   * @param type
   * @param antigen
   * @return List<BloodRepository>
   */
  List<BloodRepository> findByIdTypeAndIdAntigen(BloodTypes type, Antigens antigen);
  
  /**
   * Find all available bloods by blood bank.
   * @param bankID
   * @return List<BloodRepository>
   */
  List<BloodRepository> findByIdBank(BloodBank bank);
}
