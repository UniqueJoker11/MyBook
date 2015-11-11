package colin.profile.opensource.system;

import colin.profile.opensource.BaseTestDao;
import colin.profile.opensource.system.core.dao.BkUserDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by DELL on 2015/11/11.
 */
public class BkUserDaoTest extends BaseTestDao {
    @Autowired
    private BkUserDao userDao;
    @Test
    public void getUserInfoByUsernameTest(){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("username","colin");
        userDao.fetchBkUserInfoByUsername(params);
    }
}
