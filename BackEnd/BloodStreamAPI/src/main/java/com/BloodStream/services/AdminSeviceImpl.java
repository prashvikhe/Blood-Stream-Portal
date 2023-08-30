package com.BloodStream.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.BloodStream.dao.AdminRepository;
import com.BloodStream.dao.UserRepository;
import com.BloodStream.dto.BloodBankRepositoryIdDTO;
import com.BloodStream.enums.Role;
import com.BloodStream.exceptions.AdminException;
import com.BloodStream.exceptions.BloodRepositoryException;
import com.BloodStream.pojos.BloodRepository;
import com.BloodStream.pojos.BloodRepositoryID;
import com.BloodStream.pojos.User;

@Service
@Transactional
public class AdminSeviceImpl implements IAdminService {
	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> featchAllUsers() {

		return adminRepo.findAll();
	}


	@Override
	public List<User> findByRole(Role user) {
		return adminRepo.findByRole(user);

	}

	@Override
	public User updateActivatedById(Long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new AdminException("Fetching by Id failed inside service"));
		user.setActivated(!user.isActivated());
		return userRepo.save(user);
	}

//find all suspended users list
	@Override
	public List<User> findByActivated(boolean activated) {
		return adminRepo.findByActivated(activated);
	}
}
