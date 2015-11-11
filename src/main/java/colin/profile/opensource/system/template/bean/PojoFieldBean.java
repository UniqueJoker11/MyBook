package colin.profile.opensource.system.template.bean;

public class PojoFieldBean {
	private String name;
	private boolean isPk;
	private String type;
	private String length;
	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsPk() {
		return isPk;
	}

	public void setIsPk(boolean isPk) {
		this.isPk = isPk;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
