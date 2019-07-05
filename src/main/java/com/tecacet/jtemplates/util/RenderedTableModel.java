package com.tecacet.jtemplates.util;

import javax.swing.table.TableModel;
import java.text.Format;

public interface RenderedTableModel extends TableModel {

    void registerFormat(Class<?> clazz, Format format);

    void registerFormat(int columnIndex, Format format);

}