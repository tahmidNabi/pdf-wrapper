package com.tnob.api;

import java.util.List;

/**
 * Created by tahmid on 3/7/15.
 */
public class ListRowMapper implements RowMapper<List>{

    @Override
    public Object[] getRow(List rowData) {
        return rowData.toArray();
    }
}
