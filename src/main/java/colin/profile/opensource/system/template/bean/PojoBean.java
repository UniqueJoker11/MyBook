package colin.profile.opensource.system.template.bean;

import java.util.List;

public class PojoBean {

	private String packageName;
	private String tableName;
	private String className;
	private List<PojoFieldBean> fileldList;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<PojoFieldBean> getFileldList() {
		return fileldList;
	}

	public void setFileldList(List<PojoFieldBean> fileldList) {
		this.fileldList = fileldList;
	}

}
