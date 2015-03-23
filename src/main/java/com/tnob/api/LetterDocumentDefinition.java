package com.tnob.api;

import java.util.Date;

/**
 * Created by tahmid on 3/20/15.
 */

/**
 * components of a formal/business letter
 */
public class LetterDocumentDefinition {

    MailingAddress returnAddress;
    Date writingDate;
    MailingAddress recipientAddress;
    String greeting;
    String subject;
    String bodyIntro;
    String bodyDescription;
    String bodyConclusion;
    String letterWriter;

    public MailingAddress getReturnAddress() {
        return returnAddress;
    }

    public LetterDocumentDefinition setReturnAddress(MailingAddress returnAddress) {
        this.returnAddress = returnAddress;
        return this;
    }

    public Date getWritingDate() {
        return writingDate;
    }

    public LetterDocumentDefinition setWritingDate(Date writingDate) {
        this.writingDate = writingDate;
        return this;
    }

    public MailingAddress getRecipientAddress() {
        return recipientAddress;
    }

    public LetterDocumentDefinition setRecipientAddress(MailingAddress recipientAddress) {
        this.recipientAddress = recipientAddress;
        return this;
    }

    public String getGreeting() {
        return greeting;
    }

    public LetterDocumentDefinition setGreeting(String greeting) {
        this.greeting = greeting;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public LetterDocumentDefinition setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBodyIntro() {
        return bodyIntro;
    }

    public LetterDocumentDefinition setBodyIntro(String bodyIntro) {
        this.bodyIntro = bodyIntro;
        return this;
    }

    public String getBodyDescription() {
        return bodyDescription;
    }

    public LetterDocumentDefinition setBodyDescription(String bodyDescription) {
        this.bodyDescription = bodyDescription;
        return this;
    }

    public String getBodyConclusion() {
        return bodyConclusion;
    }

    public LetterDocumentDefinition setBodyConclusion(String bodyConclusion) {
        this.bodyConclusion = bodyConclusion;
        return this;
    }

    public String getLetterWriter() {
        return letterWriter;
    }

    public LetterDocumentDefinition setLetterWriter(String letterWriter) {
        this.letterWriter = letterWriter;
        return this;
    }
}
