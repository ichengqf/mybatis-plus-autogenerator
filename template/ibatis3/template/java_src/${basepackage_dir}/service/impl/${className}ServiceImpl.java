<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign tableRemarks = table.remarks>
package ${basepackage}.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @${className}ServiceImpl
 * @${tableRemarks}ServiceImpl
 * @version : Ver 1.0
 */
@Service
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}> implements ${className}Service {

    @Autowired
    private ${className}Mapper ${classNameLower}Mapper;

    /**
     * @根据条件查找${tableRemarks}
     * @param ${classNameLower}
     * @return
     */
    @Override
    public List<${className}> selectByCondition(${className} ${classNameLower}) {
        return ${classNameLower}Mapper.selectByCondition(${classNameLower});
    }
}
