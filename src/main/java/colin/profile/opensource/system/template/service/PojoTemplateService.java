package colin.profile.opensource.system.template.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.FileResourceLoader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import colin.profile.opensource.system.template.bean.PojoBean;
import colin.profile.opensource.system.template.bean.PojoFieldBean;

public class PojoTemplateService extends BaseTemplateService {

	/**
	 * 
	 * 方法描述：返回pojo实体类   
	 * 注意事项：    
	 * @return
	 * @throws java.io.FileNotFoundException
	 * @throws java.io.IOException
	 * @throws DocumentException 
	 * @Exception 异常对象
	 */
	public List<PojoBean> generatePojoBeans() throws FileNotFoundException,
			IOException, DocumentException {
		// 获取根节点
		Element rootElement = super.loadRootEle("template_pojo.xml");
		List<Element> pojoEles = rootElement.elements("pojo");
		List<PojoBean> pojos = new ArrayList<PojoBean>();
		for (Element pojo : pojoEles) {
			if (!Boolean.valueOf(pojo.attributeValue("hasCreate"))) {
				PojoBean pojoBean = new PojoBean();
				pojoBean.setClassName(pojo.attributeValue("name"));
				pojoBean.setPackageName(pojo.attributeValue("package"));
				pojoBean.setTableName(pojo.attributeValue("tablename"));
				List<Element> fieldEles = pojo.elements("field");
				List<PojoFieldBean> fieldList = new ArrayList<PojoFieldBean>();
				for (Element field : fieldEles) {
					PojoFieldBean fieldBean = new PojoFieldBean();
					if (field.attribute("isPk") != null) {
						fieldBean.setIsPk(true);
					}
					fieldBean.setComment(field.attributeValue("comment"));
					if (field.attribute("length") != null) {
						fieldBean.setLength(field.attributeValue("length"));
					}
					fieldBean.setName(field.attributeValue("name"));
					fieldBean.setType(field.attributeValue("type"));
					fieldList.add(fieldBean);
				}
				pojoBean.setFileldList(fieldList);
				pojos.add(pojoBean);
				pojo.setAttributeValue("hasCreate", "true");
			}
		}
		return pojos;
	}

	/**
	 * 
	 * 方法描述：  生成pojo类 
	 * 注意事项：    
	 * @throws DocumentException 
	 * @Exception 异常对象
	 */
	public void generatePojoClass() {
		try {
			Template beetlTemplate = super.initTemplateObj("PojoTemplate.template");
			List<PojoBean> pojoBeans = this.generatePojoBeans();
			//创建pojo的文件资源
			FileSystemResource pojoClassFile =null;
			for (PojoBean pojo : pojoBeans) {
				beetlTemplate.binding("pojo", pojo);
				//构建源文件的路径，不存在则创建
				pojoClassFile= new FileSystemResource(
						"src/main/java/"
								+ pojo.getPackageName().replace("\u002E", "/")
								+ File.separator + pojo.getClassName()
								+ ".java");
				if (!pojoClassFile.exists()) {
					System.out.println("创建Pojo源文件" + pojoClassFile.getFilename()
							+ "是否成功：" + pojoClassFile.getFile().createNewFile());
				}
				beetlTemplate.renderTo(new FileWriter(pojoClassFile.getFile()));
			}
			System.out.println("创建所有POJO文件完毕！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
