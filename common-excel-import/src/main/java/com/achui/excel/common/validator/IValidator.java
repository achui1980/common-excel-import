package com.achui.excel.common.validator;

import com.achui.excel.common.entity.Cell;
import com.achui.excel.common.entity.CellDefinition;

public interface IValidator {

	public boolean validate(Cell cell, CellDefinition cellDefinition);
	
}
