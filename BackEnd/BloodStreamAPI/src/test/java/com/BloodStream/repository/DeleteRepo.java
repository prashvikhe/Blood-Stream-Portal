package com.BloodStream.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BloodStream.pojos.BloodBank;

@SpringBootTest
public class DeleteRepo {
	@Autowired
	private com.BloodStream.dao.BankRepository bankRepo;
	
	
	@Autowired
	private com.BloodStream.dao.BloodBankRepository bbRepo;

	@Test
	void testFindAll() {
		Long id =(long) 14;
		BloodBank bank = bankRepo.findById(id).orElseThrow();
		//bbRepo.findByIdBank(bank).forEach(System.out::println);
	}
}
