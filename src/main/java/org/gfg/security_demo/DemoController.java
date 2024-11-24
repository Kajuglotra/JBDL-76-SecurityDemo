package org.gfg.security_demo;

import org.springframework.web.bind.annotation.GetMapping;
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
}
