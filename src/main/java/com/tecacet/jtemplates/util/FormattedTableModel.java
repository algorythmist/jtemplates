package com.tecacet.jtemplates.util;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.text.Format;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An adaptor from TableModel to a table that allows you to format data with
 * formats define at the type-level
 */
public class FormattedTableModel implements RenderedTableModel {

    private final TableModel model;
    private final Map<Class<?>, Format> formatByType = new HashMap<>();
    private final Map<Integer, Format> formatByColumn = new HashMap<>();

    public FormattedTableModel(TableModel model) {
        this.model = model;
    }

    public FormattedTableModel(String[] columns, List<Object[]> data) {
        model = new DefaultTableModel(columns, data.size());
        for (Object[] row : data) {
            ((DefaultTableModel) model).addRow(row);
        }
    }

    public void registerFormat(Class<?> clazz, Format format) {
        formatByType.put(clazz, format);
    }

    public void registerFormat(int columnIndex, Format format) {
        formatByColumn.put(columnIndex, format);
    }

    public void addTableModelListener(TableModelListener arg0) {
        model.addTableModelListener(arg0);
    }

    public Class<?> getColumnClass(int arg0) {
        return model.getColumnClass(arg0);
    }

    public int getColumnCount() {
        return model.getColumnCount();
    }

    public String getColumnName(int arg0) {
        return model.getColumnName(arg0);
    }

    public int getRowCount() {
        return model.getRowCount();
    }

    public Object getValueAt(int row, int col) {
        Format format = this.getFormat(col);
        if (format == null) {
            return model.getValueAt(row, col);
        } else {
            return format.format(model.getValueAt(row, col));
        }
    }

    private Format getFormat(int col) {
        Format format = formatByColumn.get(col);
        if (format == null) {
            format = formatByType.get(this.getColumnClass(col));
        }
        return format;
    }

    public boolean isCellEditable(int arg0, int arg1) {
        return model.isCellEditable(arg0, arg1);
    }

    public void removeTableModelListener(TableModelListener arg0) {
        model.removeTableModelListener(arg0);
    }

    public void setValueAt(Object arg0, int arg1, int arg2) {
        model.setValueAt(arg0, arg1, arg2);
    }

}
