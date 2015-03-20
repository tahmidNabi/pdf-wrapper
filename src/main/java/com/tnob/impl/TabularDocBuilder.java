package com.tnob.impl;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.tnob.api.CellStyle;
import com.tnob.api.CellStyleBuilder;
import com.tnob.api.RowMapper;
import com.tnob.api.TabularDocumentDefinition;

import java.util.List;

/**
 * Created by tahmid on 11/9/14.
 */

/**
 * what does client need to pass ?
 * no. of columns of table
 * columnHeaders
 * the list of data to be displayed in table
 * layout of data per each row (use a RowMapper type interface ?)
 */
public class TabularDocBuilder extends AbstractBasicDocBuilder {

    private TabularDocumentDefinition tabularDocumentDefinition;

    public TabularDocBuilder(TabularDocumentDefinition tabularDocumentDefinition) {
        this.tabularDocumentDefinition = tabularDocumentDefinition;
    }

    @Override
    protected void buildDocument(Document emptyDocument) throws Exception {
        PdfPTable table = new PdfPTable(tabularDocumentDefinition.getColumnSize());


        CellStyle cellStyle = CellStyleBuilder.getDefaultCellStyle();

        String[] columnHeaders = tabularDocumentDefinition.getColumnHeaders();

        for (String columnHeader : columnHeaders) {
            PdfPCell columnHeaderCell = new PdfPCell(new Paragraph(columnHeader));
            applyCellStyle(columnHeaderCell, cellStyle);
            table.addCell(columnHeaderCell);
        }
        table.completeRow();

        List<?> dataList = tabularDocumentDefinition.getDataList();
        RowMapper rowMapper = tabularDocumentDefinition.getRowMapper();

        for (Object rowData: dataList) {
            Object[] row = rowMapper.getRow(rowData);

            for (Object cellData: row) {
                PdfPCell cell = new PdfPCell(new Paragraph(cellData.toString()));
                applyCellStyle(cell, cellStyle);
                table.addCell(cell);
            }
            table.completeRow();
        }


        emptyDocument.add(table);

    }

    private void applyCellStyle(PdfPCell cell, CellStyle cellStyle) {
        cell.setBorderColor(cellStyle.getBorderColor());
        cell.setHorizontalAlignment(cellStyle.getHorizontalAlignment());
        cell.setVerticalAlignment(cellStyle.getVerticalAlignment());
        cell.setPaddingLeft(cellStyle.getPaddingLeft());
        cell.setNoWrap(cellStyle.isNoWrap());
    }
}
