package zhongd.member.service.advice;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhongd.member.dao.advice.IgAdviceCollectionMapper;
import zhongd.member.dao.advice.IgAdviceRecordMapper;
import zhongd.member.entity.DO.advice.IgAdviceCollection;
import zhongd.member.entity.DTO.advice.IgAdviceCollectionDTO;
import zhongd.member.entity.DTO.advice.IgAdviceRecordDTO;
import zhongd.member.entity.DTO.user.IgUserLoginDTO;

import java.util.Date;
import java.util.List;

/**
 * @Author xiezd
 * @Date 下午 9:39 星期二 2017/12/12 0012
 * @Description
 */
@Service
public class IgAdviceServiceImpl implements IgAdviceService {

    @Autowired
    IgAdviceCollectionMapper igAdviceCollectionMapper;
    @Autowired
    IgAdviceRecordMapper igAdviceRecordMapper;
    @Override
    public boolean save(IgAdviceCollection igAdviceCollection) {
        Integer igAdviceCollectionId = igAdviceCollection.getIgAdviceCollectionId();
        if(igAdviceCollectionId != null
                && igAdviceCollectionId > 0){
            IgAdviceCollection DO = igAdviceCollectionMapper.selectByPrimaryKey(igAdviceCollectionId);
            if(DO != null){
                igAdviceCollection.setIgAdviceCollectionId(DO.getIgAdviceCollectionId());
                igAdviceCollection.setUpdateBy(((IgUserLoginDTO)SecurityUtils.getSubject().getSession().getAttribute("currentUser")).getIgUserDO().getIgUserId());
                igAdviceCollection.setUpdateTime(new Date());
                return igAdviceCollectionMapper.updateByPrimaryKeySelective(igAdviceCollection) > 0;
            }else{
                return false;
            }
        }else{
            igAdviceCollection.setStatus(1);
            igAdviceCollection.setCreateBy(((IgUserLoginDTO)SecurityUtils.getSubject().getSession().getAttribute("currentUser")).getIgUserDO().getIgUserId());
            igAdviceCollection.setCreateTime(new Date());
            return igAdviceCollectionMapper.insertSelective(igAdviceCollection) > 0;
        }
    }

    @Override
    public boolean deleteById(Integer igAdviceCollectionId) {
        return igAdviceCollectionMapper.deleteByPrimaryKey(igAdviceCollectionId) > 0;
    }

    @Override
    public List<IgAdviceCollectionDTO> list(IgAdviceCollectionDTO paramMap) {
        paramMap.setCreateBy("%" + (paramMap.getCreateBy() == null?"" : paramMap.getCreateBy()) + "%");
        paramMap.setSubject("%" + (paramMap.getSubject()== null?"" : paramMap.getSubject()) + "%");
        paramMap.setOrgName("%" + (paramMap.getOrgName() == null?"" : paramMap.getOrgName()) + "%");
        return igAdviceCollectionMapper.list(paramMap);
    }

    @Override
    public List<IgAdviceCollection> getAllCollectingCollection(){
        return igAdviceCollectionMapper.getAllCollectingCollection();
    }

    @Override
    public List<IgAdviceRecordDTO> getRecordsByCollectionId(Integer igAdviceCollectionId) {
        return igAdviceRecordMapper.selectByCollectionId(igAdviceCollectionId);
    }

    @Override
    public Integer baseSave(IgAdviceCollection collection) {
        return igAdviceCollectionMapper.updateByPrimaryKeySelective(collection);
    }

    @Override
    public IgAdviceCollectionDTO getById(Integer igAdviceCollectionId) {
        return igAdviceCollectionMapper.getAdviceCollectionById(igAdviceCollectionId);
    }

    @Override
    public IgAdviceRecordDTO getByMemberIdAndCollectionId(Integer igMemberId, Integer igAdviceCollectionId) {
        return igAdviceRecordMapper.selectByMemberIdAndCollectionId(igMemberId, igAdviceCollectionId);
    }
}
