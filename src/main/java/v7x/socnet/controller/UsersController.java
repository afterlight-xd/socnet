package v7x.socnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import v7x.socnet.model.Role;
import v7x.socnet.model.Status;
import v7x.socnet.model.Users;
import v7x.socnet.service.UsersService;

import java.util.List;

@Controller
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/140.jpg")
    public String loginJPG(){
        return ("/images/140.jpg");
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<Users> users = usersService.findAll();
        model.addAttribute("users", users);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users currentUser = usersService.findByLogin(auth.getName());
        model.addAttribute("currentUser", currentUser);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUsersFrom(Users users){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUsers(Users users){
        users.setPassword(new BCryptPasswordEncoder(12).encode(users.getPassword()));
        usersService.saveUsers(users);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUsers(@PathVariable("id") Long id){
        usersService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Users users = usersService.findById(id);
        model.addAttribute("users", users);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(Users users){
        users.setPassword(new BCryptPasswordEncoder(12).encode(users.getPassword()));
        users.setStatus(Status.ACTIVE);
        users.setRole(Role.USER);
        usersService.saveUsers(users);
        return "redirect:/users";
    }

    @GetMapping("/index")
    //public String getIndexPage(){ return "index"; }
    public String getIndexPage(){ return "redirect:/users"; }

    @GetMapping("/")
    public String redirectIndexPage(){
        return "redirect:/index";
    }

    @GetMapping("/userpage")
    public String getUserpage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {
            Users user = usersService.findByLogin(auth.getName());
            model.addAttribute("user", user);
            return "/userpage";
        }
        else
            return "redirect:/auth/login";
    }

    @GetMapping("/register")
    public String getRegisterPage(){return "register";}

    @PostMapping("/register")
    public String registerUser(Users users){
        usersService.saveUsers(users);
        return "redirect:/index";
    }
}
