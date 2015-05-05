package com.achui.excel.common.entity;

import java.util.HashMap;

public class RowDefinition {

	private String internalName;
	private String externalName;
	private String packageName;
	private HashMap<String, CellDefinition> columns;
	public String getInternalName() {
		return internalName;
	}
	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}
	public String getExternalName() {
		return externalName;
	}
	public void setExternalName(String externalName) {
		this.externalName = externalName;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public HashMap<String, CellDefinition> getColumns() {
		return columns;
	}
	public void setColumns(HashMap<String, CellDefinition> columns) {
		this.columns = columns;
	}
}
