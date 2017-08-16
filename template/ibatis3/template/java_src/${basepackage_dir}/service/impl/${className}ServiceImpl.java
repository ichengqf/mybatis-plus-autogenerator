<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign tableRemarks = table.remarks>
package ${basepackage}.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;
import org.springframework.stereotype.Service;

/**
 * @${className}ServiceImpl
 * @${tableRemarks}ServiceImpl
 * @version : Ver 1.0
 */
@Service
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}> implements ${className}Service {
}
