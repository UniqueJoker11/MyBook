package colin.profile.opensource.system.template.bean;

public class DaoBean {

	private String className;
	private String packageName;
	private String extendClass;
	private String entityClass;
	private String pkType;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getExtendClass() {
		return extendClass;
	}

	public void setExtendClass(String extendClass) {
		this.extendClass = extendClass;
	}

	public String getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}

	public String getPkType() {
		return pkType;
	}

	public void setPkType(String pkType) {
		this.pkType = pkType;
	}

}
