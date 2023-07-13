package com.bootcamp.robotikka.robotikkaapi.service.process;

public interface EmailService {
    public boolean createEmail(String to,String subject,String body);
}
