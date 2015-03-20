package com.tnob.api;

/**
 * Created by tahmid on 10/29/14.
 */

/**
 * interface for generating PDF documents
 */
public interface DocBuilder {
    DocBuilder createDocument(String documentName);
}
