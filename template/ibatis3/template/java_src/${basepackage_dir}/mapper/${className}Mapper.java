<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign tableRemarks = table.remarks>
package ${basepackage}.mapper;

import ${basepackage}.model.${className};
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * @${className}Mapper
 * @${tableRemarks}Mapper
 * @version : Ver 1.0
 */
public interface ${className}Mapper extends BaseMapper<${className}>{

}
