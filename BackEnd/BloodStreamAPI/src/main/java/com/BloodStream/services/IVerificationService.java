package com.BloodStream.services;

import javax.mail.MessagingException;

import com.BloodStream.pojos.User;

public interface IVerificationService {
	void sendVerificationMail(String email) throws MessagingException;

	User verifyEmail(String email);

	public void sendOTPToChangePassword(String email) throws MessagingException;

	void changePassword(String email, String otp, String confirmpassword);
}
