/**
 * 
 */
package com.achui.excel.excel.check;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.achui.excel.excel.entity.Importfield;

/**
 * <p>Title: 旗航外贸管理软件V8.0</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: 厦门市旗航软件有限公司</p>
 * <p>Create Time: Jan 6, 2012 3:47:20 PM </p>
 * <p>Class Name: MyDataCheck.java </p>
 * @author achui
 *
 */
public class MyDataCheck implements IExcelCheck{

	public boolean checkDataLength(Importfield field, Map<String, String> msgMap) {
		String fieldValue = field.getFieldValue();
		if(StringUtils.isEmpty(fieldValue)) return true;
		if(StringUtils.isNotEmpty(field.getDataLength()) &&
				fieldValue.length() > Integer.valueOf(field.getDataLength())){
			String msg = "第"+(field.getRowIndex()+1)+"行,第"+(field.getCellIndex()+1)+"列数据超长,"+
					"合法长度为："+field.getDataLength()+",当前长度为："+fieldValue.length();
			msgMap.put("msg", msg);
			return false;
		}
		return true;
	}

	public boolean checkType(Importfield fieldField, Map<String, String> msg) {
		return true;
	}

	public boolean checkRelateTable(Importfield field,Map<String, String> msgMap) {
		String fieldValue = field.getFieldValue();
		if(StringUtils.isEmpty(fieldValue)) return true;
		if("query".equalsIgnoreCase(field.getDbOp())){
			BaseSerivce baseSerivce = (BaseSerivce)ContextUtil.getBean("BaseService");
			List list = baseSerivce.findRecordByHql(" from "+field.getRelateTable()+" where "+field.getDbOpField()+" = '"+fieldValue+"'");
			if(CollectionUtils.isEmpty(list)){
				String msg = "第"+(field.getRowIndex()+1)+"行,第"+(field.getCellIndex()+1)+"列,值：["+fieldValue+"]在表"+field.getRelateTable()+"中不存在，请手动添加后在导入";
				msgMap.put("msg", msg);
				return false;
			}else{
				return true;
			}
		}
		return true;
	}

	public boolean checkNull(Importfield field, Map<String, String> msgMap) {
		if(field.isNull()) return true;
		String fieldValue = field.getFieldValue();
		if(StringUtils.isEmpty(fieldValue)){
			String msg = "第"+(field.getRowIndex()+1)+"行,第"+(field.getCellIndex()+1)+"列值为空";
			msgMap.put("msg", msg);
			return false;
		}
		return true;
	}

}
