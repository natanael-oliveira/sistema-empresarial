package com.sistema_empresarial.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sistema_empresarial.model.Funcionario;
import com.sistema_empresarial.resource.FuncionarioResource;

public class FuncionarioTableModel extends AbstractTableModel{
	
	private FuncionarioResource funcionarioResource = new FuncionarioResource();
	private static final long serialVersionUID = 1L;
	private static FuncionarioTableModel instance;
	private List<Funcionario> rows;
	private String[] columns = {"ID","NOME","CARGO"};
	
	public static FuncionarioTableModel getInstance() {
		if(instance == null) {
			return instance = new FuncionarioTableModel();
		}
		return instance;
	}
	
	public FuncionarioTableModel(){
		build();
	}
	
	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}
	
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

	@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario f = rows.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return f.getId();
            case 1:
                return f.getName();
            case 2:
                return f.getJob();
            default:
                throw new IndexOutOfBoundsException("Coluna não encontrada!");
        }
    }
   
	public Long getColumnId(int rowIndex) {
	    return rows.get(rowIndex).getId();
	}
	
	public void addRow(Funcionario f) {
		rows.add(f);
		int indexRow = getRowCount() -1;
		fireTableRowsInserted(indexRow, indexRow);
	}
	
	public void updateRow(Funcionario f,int indexRow) {
		rows.set(indexRow, f);
		fireTableRowsUpdated(indexRow, indexRow);
	}
	
	public void removeRow(int indexRow) {
		rows.remove(indexRow);
       fireTableRowsDeleted(indexRow, indexRow);
	}
	public void build() {
		rows = new ArrayList<Funcionario>(funcionarioResource.list());
		fireTableDataChanged();
	}
	public void buildFilter(String filter) {
		rows = new ArrayList<Funcionario>(funcionarioResource.listFilter(filter));
		fireTableDataChanged();
	}
}