package com.BloodStream.services;

import java.rmi.activation.ActivationException;

import javax.mail.MessagingException;

import com.BloodStream.dto.BloodBankDTO;

public interface IAccountService {
	void userSignUp(BloodBankDTO dto) throws ActivationException, MessagingException;
}
