package colin.profile.opensource.system.template.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.beetl.core.Template;
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.springframework.core.io.FileSystemResource;

import colin.profile.opensource.system.template.bean.DaoBean;

public class DaoTemplateService extends BaseTemplateService {

	/**
	 * 
	 * 方法描述： 返回dao的实体类 注意事项：
	 * 
	 * @return
	 * @throws java.io.FileNotFoundException
	 * @throws java.io.IOException
	 * @throws DocumentException
	 * @Exception 异常对象
	 */
	private List<DaoBean> generatePojoBeans() throws FileNotFoundException,
			IOException, DocumentException {
		// 获取根节点
		Element rootElements = super.loadRootEle("template_dao.xml");
		// 获取dao节点
		List<Element> daoList = rootElements.elements("dao");
		// 存放daoBean结果list
		List<DaoBean> daoBeans = new ArrayList<DaoBean>();
		for (Element daoObj : daoList) {
			Attribute createAttr = daoObj.attribute("hasCreate");
			// 判断是否已经创建过了
			if (!Boolean.valueOf(createAttr.getStringValue())) {
				DaoBean daoBean = new DaoBean();
				// 类包名
				daoBean.setPackageName(daoObj.attributeValue("package"));
				// 类名
				daoBean.setClassName(daoObj.attributeValue("name"));
				// 实体类名
				daoBean.setEntityClass(daoObj.attributeValue("entityClass"));
				// 继承类名
				daoBean.setExtendClass(daoObj.attributeValue("extendClass"));
				// 主键类型
				daoBean.setPkType(daoObj.attributeValue("pkType"));
				daoBeans.add(daoBean);
				// 设置hasCreate属性值为true，表示创建过该类了
				createAttr.setText("true");
			}
		}
		// 保存更改后的xml文件
		try {
			super.updateTemplateXmlFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoBeans;
	}

	/**
	 * 
	 * 方法描述：生成dao类 注意事项：
	 * 
	 * @Exception 异常对象
	 */
	public void generateDaoClass() {
		try {
			// 初始化beetl模板
			Template beetlTemplate = super
					.initTemplateObj("DaoTemplate.template");
			// 初始化dao文件资源
			FileSystemResource daoClassFile = null;
			for (DaoBean daoBean : this.generatePojoBeans()) {
				beetlTemplate.binding("dao", daoBean);
				daoClassFile = new FileSystemResource("src/main/java/"
						+ daoBean.getPackageName().replace("\u002E", "/")
						+ File.separator + daoBean.getClassName() + ".java");
				// dao源文件不存在则予以创建
				if (!daoClassFile.exists()) {
					System.out.println("创建Dao源文件" + daoBean.getClassName()
							+ "结果是" + daoClassFile.getFile().createNewFile());
				}
				// 开始渲染输出dao源文件
				beetlTemplate.renderTo(new FileWriter(daoClassFile.getFile()));
			}
			System.out.println("生成所有的dao文件完毕！");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
