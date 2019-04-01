<#assign className=table.className>
<#assign tableName=table.sqlName>
<#assign classNameLower=className?uncap_first>
<#assign tableRemarks=table.remarks>
package ${basepackage}.web.api;

import ${basepackage}.commons.JsonResp;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.entity.${className};
import ${basepackage}.service.${className}Service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @${className}Controller
 * @${tableRemarks}Controller
 * @version : Ver 1.0
 */
@RestController
@RequestMapping(value="/api/${classNameLower}")
@Transactional
@CrossOrigin
public class ${className}Controller {
    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private ${className}Service ${classNameLower}Service;

    /**
     * @添加${tableRemarks}
     * @param ${classNameLower}
     * @return 返回值JsonResp
     */
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public JsonResp add${className}(@RequestBody ${className} ${classNameLower}){
        log.debug("添加${tableRemarks}");
<#list table.columns as column>
<#if column.sqlName=='gmt_datetime'>
        ${classNameLower}.setGmtDatetime(new Date());
</#if>
</#list>
        ${classNameLower}Service.insert(${classNameLower});
        return JsonResp.ok(${classNameLower});
    }

    /**
     * @修改${tableRemarks}
     * @param ${classNameLower}
     * @return 返回值JsonResp
     */
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public JsonResp update${className}(@RequestBody ${className} ${classNameLower}){
        log.debug("修改${tableRemarks}");
<#list table.columns as column>
<#if column.sqlName=='upt_datetime'>
        ${classNameLower}.setUptDatetime(new Date());
</#if>
</#list>
        ${classNameLower}Service.updateById(${classNameLower});
        return JsonResp.ok(${classNameLower});
    }
    /**
     * @根据id查找${tableRemarks}
     * @param id
     * @return 返回值JsonResp
     */
    @RequestMapping(value="/selectOne", method = RequestMethod.GET)
    public JsonResp select${className}(Long id){
        log.debug("查找${tableRemarks}");
        ${className} ${classNameLower} = ${classNameLower}Service.selectById(id);
        return JsonResp.ok(${classNameLower});
    }

    /**
     * @根据条件查找${tableRemarks}
     * @param ${classNameLower}
     * @return 返回值JsonResp
     */
    @RequestMapping(value = "/selectByCondition", method = RequestMethod.POST)
    public JsonResp select${className}ByCondition(@RequestBody ${className} ${classNameLower}){
        log.debug("根据条件查找${tableRemarks}");
        if(${classNameLower}==null)
            return JsonResp.toFail("参数不能为空");
        List<${className}> ${classNameLower}List=${classNameLower}Service.selectByCondition(${classNameLower});
        return JsonResp.ok(${classNameLower}List);
    }

}
