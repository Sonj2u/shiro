package slf.sj.security.dao;

import slf.sj.security.entity.SysUser;

/**
 * Created by sj on 2017/11/16.
 */
public interface SysUserDao {

    SysUser findByUserName(String username);
}
