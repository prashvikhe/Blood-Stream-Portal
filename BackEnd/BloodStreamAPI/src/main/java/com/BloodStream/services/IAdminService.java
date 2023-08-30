package com.BloodStream.services;

import java.util.List;
import java.util.Optional;

import com.BloodStream.enums.Role;
import com.BloodStream.pojos.BloodRepository;
import com.BloodStream.pojos.User;

public interface IAdminService {
	List<User> featchAllUsers();

	List<User> findByRole(Role role);

	// User updateUserActivation(User user);
	User updateActivatedById(Long id);

     //list activation status of users   
	List<User> findByActivated(boolean activated);

}
