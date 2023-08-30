package com.BloodStream.services;

import java.rmi.activation.ActivationException;

import javax.mail.MessagingException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BloodStream.dao.BankRepository;
import com.BloodStream.dao.BloodBankRepository;
import com.BloodStream.dao.IBDCampRepo;
import com.BloodStream.dao.UserRepository;
import com.BloodStream.dto.BloodBankDTO;
import com.BloodStream.dto.MessageResponse;
import com.BloodStream.pojos.BDCamp;
import com.BloodStream.pojos.BloodBank;
import com.BloodStream.pojos.User;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BankRepository bankRepo;

	@Autowired
	private IBDCampRepo campRepo;

	@Autowired
	private IVerificationService verification;

	@Transactional(rollbackFor = MessagingException.class)
	public void userSignUp(BloodBankDTO signupRequest) throws ActivationException, MessagingException {

		// username must be unique
		if (userRepository.existsByUsername(signupRequest.getUsername())) {
			throw new ActivationException("Username already taken");
		}
		// email must be unique
		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			throw new ActivationException("Email already exist");
		}
		// Encodeing password
		signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
		User user = mapper.map(signupRequest, User.class);
		user.setActivated(true);
		System.out.println(user);
		User use = userRepository.save(user);
		
		if (signupRequest.getRole().equals("BLOOD_BANK")) {
			BloodBank bank = mapper.map(signupRequest, BloodBank.class);
			bank.setUserId(use.getId());
			bankRepo.save(bank);
		}
		if (signupRequest.getRole().equals("CAMP")) {
			BDCamp camp = mapper.map(signupRequest, BDCamp.class);
			camp.setUserId(use.getId());

			campRepo.save(camp);
		}
		//verification.sendVerificationMail(user.getEmail());

	}

}
