package com.BloodStream.services;

import com.BloodStream.pojos.User;
import com.BloodStream.pojos.UserAddress;

public interface IUserAddressService {
	
	// save user address details
	User saveAddress(Long userId,UserAddress address);
	
	// delete user address details
	boolean deleteAddressById(Long userId);

	
	
}
