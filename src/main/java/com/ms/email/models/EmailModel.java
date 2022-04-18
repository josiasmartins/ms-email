package com.ms.email.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

// lombok.Data: para não precisar usar os método gets sets
@Data
// @Entity: classe de entidade
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel  {

    private static final long serialVersionUID = 1l;

    @Id
    // GeneratedValue: geração automatica
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
}
