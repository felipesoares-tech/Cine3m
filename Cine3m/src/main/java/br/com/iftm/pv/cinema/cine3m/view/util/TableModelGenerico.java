package br.com.iftm.pv.cinema.cine3m.view.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelGenerico<T> extends AbstractTableModel {

    private List<T> data = new ArrayList<>();
    private List<String> columnNames = new ArrayList<>();
    private List<Field> fields = new ArrayList<>();
    private Class<?> classe;

    public TableModelGenerico(Class<?> classe) {
        this.classe = classe;
        buscaCampos();
        buscaNomeColunas();
    }

    public TableModelGenerico(Class<?> classe, List<String> colunas) {
        this.classe = classe;
        buscaCampos();
        buscaNomeColunas(colunas);
    }

    private void buscaCampos() {
        Class<?> superClasse = classe.getSuperclass();
        Field[] camposClasseFilha = classe.getDeclaredFields();
        if (superClasse != null) {
            Field[] camposSuperClasse = superClasse.getDeclaredFields();
            for (Field f : camposSuperClasse) {
                f.setAccessible(true);
                fields.add(f);
            }
        }
        for (Field f : camposClasseFilha) {
            f.setAccessible(true);
            fields.add(f);
        }
    }

    private void buscaNomeColunas() {
        for (Field field : fields) {
            columnNames.add(field.getName());
        }
    }

    private void buscaNomeColunas(List<String> colunas) {
        for (Field field : fields) {
            if (colunas.contains(field.getName())) {
                columnNames.add(field.getName());
            }
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            T obj = data.get(rowIndex);
            Field field = fields.get(columnIndex);
            field.setAccessible(true);
            return field.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    public void setData(List<T> objs) {
        this.data = objs;
        fireTableRowsInserted(data.size() - objs.size(), data.size() - 1);
    }
}
