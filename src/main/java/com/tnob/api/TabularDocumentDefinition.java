package com.tnob.api;

import java.util.List;

/**
 * Created by tahmid on 11/9/14.
 */
public class TabularDocumentDefinition {
    int columnSize;
    String[] columnHeaders;
    List<?> dataList;
    RowMapper rowMapper;

    public TabularDocumentDefinition(int columnSize, String[] columnHeaders, List<?> dataList, RowMapper rowMapper) {
        this.columnSize = columnSize;
        this.columnHeaders = columnHeaders;
        this.dataList = dataList;
        this.rowMapper = rowMapper;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public String[] getColumnHeaders() {
        return columnHeaders;
    }

    public void setColumnHeaders(String[] columnHeaders) {
        this.columnHeaders = columnHeaders;
    }

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public RowMapper getRowMapper() {
        return rowMapper;
    }

    public void setRowMapper(RowMapper rowMapper) {
        this.rowMapper = rowMapper;
    }
}
