package zhongd.member.service.user;

import zhongd.member.entity.DO.user.IgUser;
import zhongd.member.entity.DTO.user.IgUserDTO;
import zhongd.member.entity.ReturnObj;

import java.util.List;
import java.util.Map;

public interface IgUserService {

	/**
	 * 根据用户名找user
	 * @param username
	 * @return
	 */
	IgUser getIgUserByUsername(String username);

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	ReturnObj login(IgUser user);

	/**
	 * 得到用户角色集合
	 * @param igUserId
	 * @return
	 */
	Map<String, Object> getUserRoleSet(Integer igUserId);
	Map<String, Object> getUserUserPermissions(Integer igUserId);
	/**
	 * 插入一条用户记录
	 * @param user
	 * @return
	 */


	int insert(IgUser user);

	/**
	 * 根据主键删除记录
	 * @param user
	 * @return
	 */
	int deleteById(IgUser user);

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int update(IgUser user);

	/**
	 * 分页获取用户列表
	 * @param pageSize
	 * @param pageIndex
	 * @param queryUser
	 * @return
	 */
	List<IgUserDTO> list(int pageSize, int pageIndex, IgUserDTO queryUser);

	/**
	 * 为用户设定角色
	 * @param igUserId
	 * @param igRoleId
	 * @param currentUserId
	 * @return
	 */
	int setRole(Integer igUserId, Integer igRoleId, Integer currentUserId);

	int rmRole(Integer igUserId, Integer igRoleId);

	Map<String, Object> getUserRoleSelectSet(Integer igUserId);
}