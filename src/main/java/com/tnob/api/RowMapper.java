package com.tnob.api;

/**
 * Created by tahmid on 11/9/14.
 */
public interface RowMapper<T> {
    public Object[] getRow(T rowData);
}
