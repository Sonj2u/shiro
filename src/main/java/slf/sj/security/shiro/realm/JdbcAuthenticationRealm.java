package slf.sj.security.shiro.realm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import slf.sj.security.biz.SysUserBiz;
import slf.sj.security.entity.SysUser;

/**
 * Created by sj on 2017/11/16.
 */
public class JdbcAuthenticationRealm extends AuthorizationRealm {

    @Autowired
    private SysUserBiz sysUserBiz;

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        // TODO - doGetAuthenticationInfo 完善
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        if (StringUtils.isBlank(String.valueOf(token.getPassword()))) {
            throw new AccountException("用户名或密码错误");
        }
        if (token.isRememberMe()) {
            token.setRememberMe(true);
        }
        String username = token.getUsername();
        SysUser sysUser = sysUserBiz.findByUserName(username);
        if (sysUser == null) {
            throw new UnknownAccountException("用户名或密码错误");
        }
        if (Boolean.TRUE.equals(sysUser.getLocked())) {
            throw new LockedAccountException("账户已被锁定");
        }
        return new SimpleAuthenticationInfo(username, sysUser.getPassword(), getName());
    }
}
