package com.springboot.service;



import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MailService {

	JavaMailSender mailSender;
	
	public MailService(JavaMailSender mailSender) {
		this.mailSender=mailSender;
	}
	
	public void sendMail(String to,String subject,String text) {
		SimpleMailMessage sm=new SimpleMailMessage();
		sm.setTo(to);
		sm.setSubject(subject);
		sm.setText(text);
		mailSender.send(sm);
	}
	
}
