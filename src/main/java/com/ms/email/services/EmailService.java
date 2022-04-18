package com.ms.email.services;

import com.ms.email.EmailRepository;
import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService  {

    // Autowired: para fazer a persistencia com o banco. Get, put, delete,
    @Autowired
    EmailRepository emailRepository;

    // injeção de serviço
    @Autowired
    private JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        // realiza o envio e a persistencia
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            // se tudo der certo, salva no emailModel
            emailModel.setStatusEmail(StatusEmail.SEND);
            // se tiver algum erro, cai no catch
        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
            // tenta enviar novamente o email
        } finally {
            return emailRepository.save(emailModel);
        }
    }
}
