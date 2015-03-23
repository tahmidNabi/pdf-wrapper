package com.tnob.impl;


import com.lowagie.text.*;
import com.tnob.api.LetterDocumentDefinition;
import com.tnob.api.MailingAddress;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;

/**
 * Created by tahmid on 3/20/15.
 */
public class LetterDocBuilder extends AbstractBasicDocBuilder{

    private LetterDocumentDefinition letterDocumentDefinition;
    private static final Font letterFont = FontFactory.getFont("Times-Roman", 12);

    public LetterDocBuilder(LetterDocumentDefinition letterDocumentDefinition) {
        this.letterDocumentDefinition = letterDocumentDefinition;
    }

    @Override
    protected void buildDocument(Document emptyDocument) throws Exception {

        Paragraph returnAddressParagraph = createReturnAddressSection();
        Paragraph dateParagraph = createDateSection();
        Paragraph recipientAddressParagraph = createRecipientAddressSection();
        Paragraph subjectParagraph = createSubjectSection();
        Paragraph greetingParagraph = createGreetingSection();
        Paragraph bodyParagraph = createBody();
        Paragraph closingParagraph = createClosing();

        emptyDocument.add(returnAddressParagraph);
        emptyDocument.add(dateParagraph);
        emptyDocument.add(recipientAddressParagraph);
        emptyDocument.add(subjectParagraph);
        emptyDocument.add(greetingParagraph);
        emptyDocument.add(bodyParagraph);
        emptyDocument.add(closingParagraph);

    }

    private Paragraph createClosing() {
        Paragraph closingParagraph = new Paragraph();
        closingParagraph.add(Chunk.NEWLINE);
        addToParagraph(closingParagraph, "Yours Sincerely, ");
        closingParagraph.add(Chunk.NEWLINE);
        String letterWriter = letterDocumentDefinition.getLetterWriter();
        addToParagraph(closingParagraph, letterWriter);
        closingParagraph.add(Chunk.NEWLINE);
        return closingParagraph;
    }

    private Paragraph createBody() {
        Paragraph bodyParagraph = new Paragraph();
        bodyParagraph.setAlignment(Element.ALIGN_JUSTIFIED);
        bodyParagraph.add(Chunk.NEWLINE);
        addToParagraph(bodyParagraph, letterDocumentDefinition.getBodyIntro());
        bodyParagraph.add(Chunk.NEWLINE);
        addToParagraph(bodyParagraph, letterDocumentDefinition.getBodyDescription());
        bodyParagraph.add(Chunk.NEWLINE);
        addToParagraph(bodyParagraph, letterDocumentDefinition.getBodyConclusion());
        bodyParagraph.add(Chunk.NEWLINE);
        return bodyParagraph;
    }

    private Paragraph createGreetingSection() {
        Paragraph greetingParagraph = new Paragraph();
        greetingParagraph.add(Chunk.NEWLINE);
        addToParagraph(greetingParagraph, letterDocumentDefinition.getGreeting());
        greetingParagraph.add(Chunk.NEWLINE);
        return greetingParagraph;
    }

    private Paragraph createSubjectSection() {
        Paragraph subjectParagraph = new Paragraph();
        String subject = letterDocumentDefinition.getSubject();

        if(StringUtils.isNotEmpty(subject)) {
            subjectParagraph.add(Chunk.NEWLINE);
            Chunk subjectChunk = new Chunk("Subject: ", letterFont);
            subjectChunk.append(subject);
            subjectParagraph.add(subjectChunk);
            subjectParagraph.add(Chunk.NEWLINE);
        }
        return subjectParagraph;
    }

    private Paragraph createRecipientAddressSection() {
        MailingAddress recipientAddress = letterDocumentDefinition.getRecipientAddress();
        Paragraph recipientAddressParagraph = new Paragraph();
        recipientAddressParagraph.add(Chunk.NEWLINE);
        writeAddress(letterFont, recipientAddress, recipientAddressParagraph);
        return recipientAddressParagraph;
    }

    private Paragraph createDateSection() {
        Paragraph dateParagraph = new Paragraph();
        dateParagraph.add(Chunk.NEWLINE);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String formattedWritingDate = dateFormat.format(letterDocumentDefinition.getWritingDate());

        addToParagraph(dateParagraph, formattedWritingDate);
        dateParagraph.add(Chunk.NEWLINE);
        return dateParagraph;
    }

    private Paragraph createReturnAddressSection() {
        Paragraph returnAddressParagraph = new Paragraph();
        MailingAddress returnAddress = letterDocumentDefinition.getReturnAddress();
        writeAddress(letterFont, returnAddress, returnAddressParagraph);
        return returnAddressParagraph;
    }

    private void writeAddress(Font font, MailingAddress mailingAddress, Paragraph paragraph) {
        paragraph.setAlignment(Element.ALIGN_LEFT);

        paragraph.add(new Chunk(mailingAddress.getRecipientName(), font));
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(new Chunk(mailingAddress.getDeliveryAddressLine(), font));
        paragraph.add(Chunk.NEWLINE);

        Chunk lastLine = new Chunk();
        lastLine.setFont(font);
        lastLine.append(mailingAddress.getCity())
                .append(",")
                .append(" ")
                .append(mailingAddress.getState())
                .append(" ")
                .append(mailingAddress.getZipCode());

        paragraph.add(lastLine);
        paragraph.add(Chunk.NEWLINE);
    }

    /**
     * method used to avoid having to pass font everytime in a paragraph
     * @param paragraph
     * @param string
     */
    public static void addToParagraph(Paragraph paragraph, String string) {
        paragraph.add(new Chunk(string, letterFont));
    }
}
