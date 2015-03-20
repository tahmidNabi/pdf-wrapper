package com.tnob.api;

import com.lowagie.text.Element;

import java.awt.*;

/**
 * Created by tahmid on 3/7/15.
 */
public class CellStyleBuilder {
    public static CellStyle getDefaultCellStyle() {
        CellStyle defaultCellStyle = new CellStyle();
        defaultCellStyle.setBorderColor(Color.BLACK);
        defaultCellStyle.setHorizontalAlignment(Element.ALIGN_CENTER);
        defaultCellStyle.setVerticalAlignment(Element.ALIGN_MIDDLE);
        defaultCellStyle.setPaddingLeft(10);
        defaultCellStyle.setNoWrap(Boolean.FALSE);
        return defaultCellStyle;
    }
}
