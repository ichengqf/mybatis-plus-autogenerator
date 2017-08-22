/*
 * Beijing happy Information Technology Co,Ltd.
 * All rights reserved.
 * 
 * <p>GeneratroMain.java</p>
 */
package generator;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;

import java.io.IOException;

/**
 * 运行main方法生成dao,service,model
 *
 * @version : Ver 1.0
 * @author : <a href="mailto:h358911056@qq.com">hubo</a>
 * @date : 2015年5月31日 下午3:13:02
 */
public class GeneratorMain {

	private final static GeneratorFacade g = new GeneratorFacade();

	/**
	 * 按表名生成dao,service,model
	 *
	 * @author : <a href="mailto:h358911056@qq.com">hubo</a> 2015年5月31日
	 *         下午3:19:17
	 * @param tabaleNames 表名数组
	 * @throws Exception
	 */
	public static void generateByTable(String...tabaleNames) throws Exception {
		if (null != tabaleNames && tabaleNames.length > 0) {
			for (String tbname : tabaleNames) {
				g.generateByTable(tbname, "template");
			}
		}
	}

	/**
	 * 生成所有表对应的dao,service,model
	 *
	 * @author : <a href="mailto:h358911056@qq.com">hubo</a> 2015年5月31日
	 *         下午3:19:40
	 * @throws Exception
	 */
	public static void generateByAllTable() throws Exception {
		g.generateByAllTable("template"); // 生成所有表
	}
	
	/**
	 * 弹开磁盘生成的文件
	 *
	 * @author 	: <a href="mailto:h358911056@qq.com">hubo</a>  2015年5月31日 下午3:25:50
	 * @throws IOException
	 */
	public static void openDir() throws IOException{
		Runtime.getRuntime().exec("cmd.exe /c start "+ GeneratorProperties.getRequiredProperty("outRoot"));
	}

	
	public static void main(String[] args) throws Exception {
		g.deleteOutRootDir(); // 清空目录

//		String [] table_names = new String[]{"classify_y", "classify"};
//		String [] table_names = new String[]{"sku"};
//		generateByTable(table_names); //按表名生成
		
		generateByAllTable();//生成全部表
		
		
		openDir();
	}
	
}
