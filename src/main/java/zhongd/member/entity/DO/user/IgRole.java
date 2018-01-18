package zhongd.member.entity.DO.user;

import zhongd.member.entity.DO.BaseDO;

import javax.persistence.Id;

public class IgRole extends BaseDO {
	@Id
	private Integer igRoleId;
	private String roleName;
	private String roleCode;
	private String description;
	public Integer getIgRoleId() {
		return igRoleId;
	}
	public void setIgRoleId(Integer igRoleId) {
		this.igRoleId = igRoleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
