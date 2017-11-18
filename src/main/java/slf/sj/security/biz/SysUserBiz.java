package slf.sj.security.biz;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slf.sj.security.dao.SysUserDao;
import slf.sj.security.entity.SysUser;

/**
 * Created by sj on 2017/11/17.
 */
@Service
public class SysUserBiz {

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return
     */
    public SysUser findByUserName(String username) {
        if (StringUtils.isBlank(username)) {
            return null;
        }
        return sysUserDao.findByUserName(username);
    }
}
