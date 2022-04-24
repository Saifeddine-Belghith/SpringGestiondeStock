package com.sip.ams;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.boot.CommandLineRunner;

import java.io.*;

import javax.mail.MessagingException;

import com.sip.ams.controllers.ArticleController;
import com.sip.ams.controllers.ProviderController;

@SpringBootApplication
@EnableJpaRepositories
public class ProjetfinalgestiondestockApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private JavaMailSender javaMailSender;
	void sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("saifbelghith12@gmail.com");
		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");
		javaMailSender.send(msg);
	}
	@Override
	 public void run(String... args) throws MessagingException, 
	IOException {
	 System.out.println("Sending Email...");
	 sendEmail();
	 System.out.println("Done");
	 }

	public static void main(String[] args) {
		new File(ArticleController.uploadDirectory).mkdir();
		new File(ProviderController.uploadDirectory).mkdirs();
		SpringApplication.run(ProjetfinalgestiondestockApplication.class, args);

		}


}