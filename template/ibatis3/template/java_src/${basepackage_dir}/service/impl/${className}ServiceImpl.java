<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign tableRemarks = table.remarks>
package ${basepackage}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.entity.${className};
import ${basepackage}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * ${tableRemarks}ServiceImpl
 * 
 * <p>
 * SVW SX Copyright (C) SAIC VOLKSWAGEN, All rights reserved.
 * 
 * @author svwsx
 * @date 2019-03-28 13:14
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
