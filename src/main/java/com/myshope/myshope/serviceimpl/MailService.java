package com.myshope.myshope.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	
	   @Autowired
	    private JavaMailSender mailSender;

	    public void sendEmail(String to, String subject, String body) {
	    	 System.out.println("java mai sent start!");
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("ashvinmajethiya22@gmail.com");
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
	        System.out.println("java mai sent success!");
	    }
	

}
