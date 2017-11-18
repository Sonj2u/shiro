package slf.sj.security.shiro.filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by sj on 17-11-18.
 */
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.getAndClearSavedRequest(request);
        WebUtils.redirectToSavedRequest(request, response, "/index");
        return false;
    }

    @Override
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        if (ae instanceof UnknownAccountException || ae instanceof IncorrectCredentialsException) {
            request.setAttribute(getFailureKeyAttribute(), "用户名或密码错误");
        } else if (ae instanceof LockedAccountException) {
            request.setAttribute(getFailureKeyAttribute(), "账户被锁定，请联系管理员");
        } else {
            request.setAttribute(getFailureKeyAttribute(), "账号异常，请联系管理员");
        }
    }

}
