package cn.geodata.models.wetland.actions.map;

import cn.geodata.models.ProcessContainer;

public abstract class AbstractProcess {
	protected ProcessManage manage;

	public ProcessManage getManage() {
		return manage;
	}

	public void setManage(ProcessManage manage) {
		this.manage = manage;
	}
}
