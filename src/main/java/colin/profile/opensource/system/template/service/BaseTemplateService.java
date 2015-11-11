package colin.profile.opensource.system.template.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import colin.profile.opensource.system.template.bean.PojoBean;

public class BaseTemplateService {

	protected ClassPathResource templateXmlResources=null;
	protected Document pojoDoc=null;

	/**
	 * 
	 * 方法描述： 返回根节点内容 注意事项：
	 * 
	 * @return
	 * @throws java.io.FileNotFoundException
	 * @throws java.io.IOException
	 * @throws DocumentException
	 * @Exception 异常对象
	 */
	protected Element loadRootEle(String filename)
			throws FileNotFoundException, IOException, DocumentException {
		SAXReader reader = new SAXReader();
		templateXmlResources = new ClassPathResource("config" + File.separator
				+ filename);
		pojoDoc = reader.read(templateXmlResources.getFile());
		return pojoDoc.getRootElement();
	}

	/**
	 * 
	 * 方法描述：获取beetl的模板对象 注意事项：
	 * 
	 * @return
	 * @throws DocumentException
	 * @Exception 异常对象
	 */
	protected Template initTemplateObj(String templateName)
			throws DocumentException {
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader(
				"/colin/profile/opensource/system/template/template/", "utf-8");
		try {
			Configuration cfg = Configuration.defaultConfiguration();
			GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
			Template t = gt.getTemplate(templateName);
			return t;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * 方法描述： 更新修改过的xml文件 注意事项：
	 * 
	 * @throws Exception
	 * @Exception 异常对象
	 */
	protected void updateTemplateXmlFile()
			throws Exception {
		// 紧凑的格式
		// OutputFormat format = OutputFormat.createCompactFormat();
		// 排版缩进的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置编码
		format.setEncoding("UTF-8");
		// 创建XMLWriter对象,指定了写出文件及编码格式
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(
				new FileOutputStream(templateXmlResources.getFile()), "UTF-8"), format);
		// 写入
		writer.write(pojoDoc);
		// 立即写入
		writer.flush();
		// 关闭操作
		writer.close();
	}
}
