package slf.sj.security.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sj on 2017/11/17.
 */
@Controller
@RequestMapping
public class MainController {

    @RequestMapping("/index")
    public String index() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "/index";
        }
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request,
                        HttpServletResponse response) {
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            return "/login";
        }
        return "redirect:/index";
    }

    @RequestMapping("/user")
    public String test() {
        return "/user";
    }
}
