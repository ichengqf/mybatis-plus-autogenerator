<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign tableRemarks = table.remarks>
package ${basepackage}.mapper;

import ${basepackage}.entity.${className};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/***
 * ${tableRemarks}Mapper
 * 
 * <p>
 * SVW SX Copyright (C) SAIC VOLKSWAGEN, All rights reserved.
 * 
 * @author svwsx
 * @date 2019-03-28 13:14
 */
public interface ${className}Mapper extends BaseMapper<${className}>{

    /**
     * 根据条件查找${tableRemarks}
     * @param ${classNameLower}
     * @return
     */
    List<${className}>  selectByCondition(${className} ${classNameLower});

}
