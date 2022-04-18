package com.ms.email.services;

import com.ms.email.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService  {

    // Autowired: para fazer a persistencia com o banco. Get, put, delete,
    @Autowired
    EmailRepository emailRepository;
}
