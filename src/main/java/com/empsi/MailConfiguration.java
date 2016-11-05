package com.empsi;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class MailConfiguration {

		@Value("${spring.mail.host}")
	    private String host;

	    @Value("${spring.mail.properties.mail.smtp.port}")
	    private Integer port;
	    
    @Bean
    public JavaMailSender javaMailSender() {
    	
    	JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername("elidrissithai@gmail.com");
        javaMailSender.setPassword("R0naldinho");
        javaMailSender.setJavaMailProperties(getMailProperties());

        return javaMailSender;
    }
    
    public Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "false");
        return properties;
    }
}
