package com.security.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class SecurityController {

    @GetMapping("/one")
    public String getDemoOne() {
        return ("<h1>Spring Security Test Demo ONE Successful</h1>");
    }

    @GetMapping("two")
    public String getDemoTwo() {
        return ("<h1>Spring Security Test Demo TWO Successful</h1>");
    }

    @GetMapping("three")
    public String getDemoThree() {
        return ("<h1>Spring Security Test Demo THREE Successful</h1>");
    }
}
