package cn.geodata.models.glacier.actions.models;

public abstract class AbstractRunoff {
	protected ProcessManage manage;

	public ProcessManage getManage() {
		return manage;
	}

	public void setManage(ProcessManage manage) {
		this.manage = manage;
	}
}
