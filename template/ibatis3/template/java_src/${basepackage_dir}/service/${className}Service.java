<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign tableRemarks = table.remarks>
package ${basepackage}.service;

import com.baomidou.mybatisplus.service.IService;
import ${basepackage}.model.${className};

/**
 * @${className}Service
 * @${tableRemarks}Service
 * @version : Ver 1.0
 */
public interface ${className}Service extends IService<${className}>{
}
