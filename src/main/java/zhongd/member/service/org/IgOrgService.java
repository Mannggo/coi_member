package zhongd.member.service.org;

import zhongd.member.entity.DO.org.IgOrg;

import java.util.Map;

/**
 * @Author xiezd
 * @Date 下午 9:44 星期六 2017/12/2 0002
 * @Description
 */
public interface IgOrgService {
    Map<String, Object> getOrgList();

    int deleteOrgById(Integer igOrgId);

    int updateOrg(IgOrg igOrg);

    int saveOrg(IgOrg igOrg);

}
