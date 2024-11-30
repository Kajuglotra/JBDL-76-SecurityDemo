package org.gfg.security_demo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //it should be visible
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    // it should be visible to developer
    @GetMapping("/developer")
    public String developer(){
        return "developer";
    }
    // any person who has role of developer or admin
    @GetMapping("/tester")
    public String tester(){
        return "tester";
    }
    // who has admin role
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    // can accessed by anyone, you have to provide your creds
    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }

    @PostMapping("/developer/{name}")
    public String developerByName(@PathVariable String name, @AuthenticationPrincipal MyUser myUser){
//        MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "hey !!" + myUser.getUsername();
    }

    @PostMapping("/addAdmin")
    public String addAdmin(){
        return "abc";
    }
}
