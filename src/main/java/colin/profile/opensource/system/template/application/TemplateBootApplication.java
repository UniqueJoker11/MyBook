package colin.profile.opensource.system.template.application;

import org.dom4j.DocumentException;

import colin.profile.opensource.system.template.service.DaoTemplateService;
import colin.profile.opensource.system.template.service.PojoTemplateService;

public class TemplateBootApplication {

	/**
	 * 
	 * 方法描述： 生成所有的pojo源文件 注意事项：
	 * 
	 * @Exception 异常对象
	 */
	public void generatePojoSourceFile() {
		// 生成pojo类
		PojoTemplateService templateService = new PojoTemplateService();
		templateService.generatePojoClass();
	}

	/**
	 * 
	 * 方法描述：生成所有的dao源文件 注意事项：
	 * 
	 * @Exception 异常对象
	 */
	public void generateDaoSourceFile() {
		// 生成pojo类
		DaoTemplateService templateService = new DaoTemplateService();
		templateService.generateDaoClass();
	}

	public static void main(String[] args) {
		TemplateBootApplication bootApplication=new TemplateBootApplication();
		bootApplication.generatePojoSourceFile();
		//bootApplication.generateDaoSourceFile();
	}
}
