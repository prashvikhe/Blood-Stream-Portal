package com.BloodStream.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BloodStream.dao.BankRepository;
import com.BloodStream.dao.BloodBankRepository;
import com.BloodStream.dao.UserAddressRepository;
import com.BloodStream.dao.UserRepository;
import com.BloodStream.dto.BloodBankDTO;
import com.BloodStream.exceptions.ResourceNotFoundException;
import com.BloodStream.pojos.BloodBank;
import com.BloodStream.pojos.BloodRepository;
import com.BloodStream.pojos.User;
import com.BloodStream.pojos.UserAddress;

@Service
@Transactional
public class BloodBankServiceImpl implements IBloodBankService {
	
	
	@Autowired
	private BloodBankRepository brRepo;

	@Autowired
	private BankRepository bankRepo;
	
	@Autowired
	private UserRepository userRepo;
	

	@Autowired
	private UserAddressRepository addRepo;
	
	@Autowired
	private ModelMapper mapper;

	// add blood bank
	@Override
	public BloodBank saveBankDetails(BloodBankDTO bloodBank) {

	
				
		User user = mapper.map(bloodBank, User.class);
		UserAddress address = mapper.map(bloodBank, UserAddress.class);
		BloodBank bank = mapper.map(bloodBank, BloodBank.class);
		
		address.setUser(user);
		
		
		return bank;
	}

	// get blood bank details by bankId
	@Override
	public BloodBank getBankDetailsById(Long bankId) {

		return bankRepo.findById(bankId).orElseThrow();
	}


	// get blood bank details by bankName
	@Override
	public BloodBank getBankDetailsByBankName(String bankName) {

		return bankRepo.findByName(bankName).orElseThrow();
	}

	@Override
	public boolean deleteBankDetails(Long bankId) {
		BloodBank bank = bankRepo.findById(bankId).orElseThrow(()-> new ResourceNotFoundException("Entity Not found"));
		
		List<BloodRepository> list =brRepo.findByIdBank(bank);
		brRepo.deleteAll(list);
		
		bankRepo.deleteById(bankId);
		userRepo.deleteById(bank.getUserId());
		
		
		return true;
	}

	// update bank details
	@Override
	public BloodBank updateBankDetails(BloodBank bloodBank) {
		return bankRepo.save(bloodBank);
	}

  @Override
  public List<BloodBank> getAllBanks() {
    return bankRepo.findAll();
  }

  @Override
  public boolean deleteById(Long id) {
    bankRepo.deleteById(id);
    return true;
  }

}
