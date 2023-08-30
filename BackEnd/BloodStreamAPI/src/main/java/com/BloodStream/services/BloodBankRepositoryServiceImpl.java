package com.BloodStream.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BloodStream.dao.BloodBankRepository;
import com.BloodStream.dto.BloodBankRepositoryDTO;
import com.BloodStream.dto.BloodBankRepositoryIdDTO;
import com.BloodStream.exceptions.BloodRepositoryException;
import com.BloodStream.pojos.BloodBank;
import com.BloodStream.pojos.BloodRepository;
import com.BloodStream.pojos.BloodRepositoryID;

@Service
@Transactional
public class BloodBankRepositoryServiceImpl implements IBloodBankRepositoryService {
	
	
  
  @Autowired
  private BloodBankRepository bloodBankRepo;
  
  
  //error message from error_mesaages.prop
  @Value("${com.BloodStream.blood.repository.NOT_FOUND}")
  private String repoNotFound;

  @Override
  public BloodRepository addRepository(BloodBankRepositoryDTO repository) {
    return bloodBankRepo.save(BloodRepository.build(repository));
  }

  @Override
  public boolean deleteRepositoryById(BloodBankRepositoryIdDTO id) {
    bloodBankRepo.deleteById(BloodRepositoryID.build(id));
    return true;
  }

  @Override
  public BloodRepository updateRepositoryById(BloodBankRepositoryIdDTO id, int quantity) {
    BloodRepository bloodRepo = bloodBankRepo.findById(BloodRepositoryID.build(id))
                                  .orElseThrow(() -> new BloodRepositoryException(repoNotFound));
    bloodRepo.setAvailability(quantity);
    return bloodBankRepo.save(bloodRepo);
  }

  @Override
  public List<BloodRepository> findByBloodBank(Long id) {
    BloodBank bank = new BloodBank();
    bank.setId(id);
    return bloodBankRepo.findByIdBank(bank);
  }

  @Override
  public List<BloodRepository> findByBloodTypeAndAntigen(BloodBankRepositoryIdDTO id) {
    return bloodBankRepo.findByIdTypeAndIdAntigen(id.getType(), id.getAntigen());
  }
}
