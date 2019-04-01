<#include "/macro.include"/> 
<#assign className = table.className>
<#assign tableName = table.sqlName>
<#assign tableRemarks = table.remarks>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/***
 * ${tableRemarks}(${tableName})
 * 
 * <p>
 * SVW SX Copyright (C) SAIC VOLKSWAGEN, All rights reserved.
 * 
 * @author svwsx
 * @date 2019-03-28 13:14
 */
@TableName("${tableName}")
public class ${className} extends Model<${className}> implements Serializable {
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;
	<#list table.columns as column>

	<#if column.pk>
	/**
	 * @备注:${column.remarks}
	 * @字段:${column.sqlName} ${column.sqlTypeName}(${column.size})
	 */
	@TableId(type = IdType.AUTO)
	private ${column.javaType} ${column.columnNameLower};
	<#elseif column.columnNameLower=='uuid'>
	/**
	 * @备注:${column.remarks}
	 * @字段:${column.sqlName} ${column.sqlTypeName}(${column.size})
	 */
	@Column(updatable = false,columnDefinition="${column.sqlTypeName}(${column.size}) COMMENT '${column.remarks}'")
	private ${column.javaType} ${column.columnNameLower} = java.util.UUID.randomUUID().toString().replaceAll("-","");
	<#elseif column.columnNameLower=='gmtDatetime'>
	/**
	 * @备注:${column.remarks}
	 * @字段:${column.sqlName} ${column.sqlTypeName}(${column.size})
	 */
	@JsonSerialize(using=DateJsonSerializer.class)
	@JsonDeserialize(using=DateJsonDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
	@TableField("${column.sqlName}")
	private ${column.javaType} ${column.columnNameLower};
	<#elseif column.columnNameLower=='uptDatetime'>
	/**
	 * @备注:${column.remarks}
	 * @字段:${column.sqlName} ${column.sqlTypeName}(${column.size})
	 */
	@JsonSerialize(using=DateJsonSerializer.class)
	@JsonDeserialize(using=DateJsonDeserializer.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
	@TableField("${column.sqlName}")
	private ${column.javaType} ${column.columnNameLower} ;
	<#elseif column.fk>
	<#assign fkTableName = column.fkTableName>
	<#assign columnNameTwo = column.columnNameLower?substring(0,column.columnNameLower?length-2)>
	/**
	 * @备注:${column.remarks}
	 * @字段:${column.sqlName} ${column.sqlTypeName}(${column.size})
	 */
	@TableField("${column.sqlName}")
	private ${column.javaType} ${column.columnNameLower};
	/**
	 * 备注:${column.remarks}
	 */
	@TableField(exist = false)
	private ${fkTableName} ${columnNameTwo};
	<#else>
	/**
	 * @备注:${column.remarks}
	 * @字段:${column.sqlName} ${column.sqlTypeName}(${column.size})
	 */
	@TableField("${column.sqlName}")
	private ${column.javaType} ${column.columnNameLower};
	</#if>

	</#list>

	<@generateConstructor className/>
	<@generateJavaColumns/>
}
<#macro generateJavaColumns>
	<#list table.columns as column>

	<#if column.fk>
	<#assign fkTableName = column.fkTableName>
	<#assign columnNameTwoCap = column.columnNameLower?substring(0,column.columnNameLower?length-2)?cap_first>
	<#assign columnNameTwo = column.columnNameLower?substring(0,column.columnNameLower?length-2)>
	public void set${column.columnName}(${column.javaType} ${column.columnNameLower}) {
			this.${column.columnNameLower} = ${column.columnNameLower};
			}

	public ${column.javaType} get${column.columnName}() {
			return this.${column.columnNameLower};
	}
	public void set${columnNameTwoCap}(${fkTableName} ${columnNameTwo}) {
		this.${columnNameTwo} = ${columnNameTwo};
	}

	public ${fkTableName} get${columnNameTwoCap}() {
		return this.${columnNameTwo};
	}
	<#else>

	public void set${column.columnName}(${column.javaType} ${column.columnNameLower}) {
		this.${column.columnNameLower} = ${column.columnNameLower};
	}

	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#if>
	</#list>
</#macro>
<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>

	private ${fkPojoClass} ${fkPojoClassVar};

	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}

	public ${fkPojoClass} get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	</#list>
</#macro>