package colin.profile.opensource.system.service;

import colin.profile.opensource.system.core.dao.BkUserDao;
import colin.profile.opensource.system.core.pojo.BkUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
public class BkUserService {

    @Autowired
    private BkUserDao userDao;

    /**
     * 根据用户名来
     * @param username
     * @return
     */
    public BkUserEntity queryUserInfoByUserName(String username){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("username",username);
        return userDao.fetchBkUserInfoByUsername(params);
    }
}
