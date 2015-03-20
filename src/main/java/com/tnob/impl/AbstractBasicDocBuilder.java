package com.tnob.impl;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.tnob.api.DocBuilder;

import java.io.FileOutputStream;

/**
 * Created by tahmid on 11/9/14.
 */

/**
 * this class takes care of generation of the actual PDF document. Classes extending
 * this class should implement the buildDocument method to describe logic for populating
 * document content
 */
public abstract class AbstractBasicDocBuilder implements DocBuilder {
    @Override
    public DocBuilder createDocument(String documentName) {
        Document document = new Document();


        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(documentName));
            document.open();

            buildDocument(document);

            document.close();
            writer.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return this;
    }

    abstract protected void buildDocument(Document emptyDocument) throws Exception;
}
