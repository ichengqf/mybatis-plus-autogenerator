<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign tableRemarks = table.remarks>
package ${basepackage}.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ${basepackage}.entity.${className};

import java.util.List;


/***
 * ${tableRemarks}Service
 * 
 * <p>
 * SVW SX Copyright (C) SAIC VOLKSWAGEN, All rights reserved.
 * 
 * @author svwsx
 * @date 2019-03-28 13:14
 */
public interface ${className}Service extends IService<${className}>{

    /**
     * @根据条件查找${tableRemarks}
     * @param ${classNameLower}
     * @return
     */
    List<${className}> selectByCondition(${className} ${classNameLower});
}
