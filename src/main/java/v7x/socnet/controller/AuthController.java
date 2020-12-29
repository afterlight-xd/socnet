package v7x.socnet.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import v7x.socnet.model.Users;
import v7x.socnet.security.UserDetailsServiceImpl;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String getLoginPage(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth.isAuthenticated())
//            return "redirect:../userpage";
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }


//    @GetMapping("/")
//    public String getLoginPage2() {
//        return "redirect:/login";
//    }

//    @GetMapping("/auth")
//    public String getRedirected() {
//        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
//            return "redirect:/index";
//        else
//            return "redirect:/auth/login";
//    }


}
