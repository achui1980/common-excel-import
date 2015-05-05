package com.achui.excel.common.entity;

import java.util.List;

public class CellDefinition {

	private String id;
	private String cellName;
	private String dataType;
	private List<CellAttr> attrs;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCellName() {
		return cellName;
	}
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public List<CellAttr> getAttrs() {
		return attrs;
	}
	public void setAttrs(List<CellAttr> attrs) {
		this.attrs = attrs;
	}
	
	
}
