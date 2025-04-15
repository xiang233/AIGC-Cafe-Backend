package com.aigccafe.buterin.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "index.html";
    }

    @GetMapping("/register")
    public String register() {
        return "index.html";
    }

    @GetMapping("/model-detail")
    public String detail() {
        return "index.html";
    }

    @GetMapping("/images")
    public String image() {
        return "index.html";
    }

    @GetMapping("/search")
    public String search() {
        return "index.html";
    }

    @GetMapping("/user")
    public String user() {
        return "index.html";
    }

    @GetMapping("/user-center")
    public String userCenter() {
        return "index.html";
    }

    @GetMapping("/user-store")
    public String userStore() {
        return "index.html";
    }

    @GetMapping("/document")
    public String document() {
        return "index.html";
    }

    @GetMapping("/note")
    public String note() {
        return "index.html";
    }

    @GetMapping("/note-detail")
    public String noteDetail() {
        return "index.html";
    }

    @GetMapping("/document-detail")
    public String documentDetail() {
        return "index.html";
    }

    @GetMapping("/user-protocol")
    public String test() {
        return "index.html";
    }

    @GetMapping("/privacy-protocol")
    public String privacyProtocol() {
        return "index.html";
    }

    @GetMapping("/md")
    public String midjourneyMember() {
        return "index.html";
    }

    @GetMapping("/mj")
    public String midjourney() {
        return "index.html";
    }

    @GetMapping("/sd")
    public String stableDiffusion() {
        return "index.html";
    }

    @GetMapping("/manager")
    public String managerIndex() {
        return "/manager/manager_index.html";
    }

    @GetMapping("/manager/login")
    public String managerLogin() {
        return "/manager/manager_index.html";
    }

    @GetMapping("/manager/note-list")
    public String noteList() {
        return "/manager/manager_index.html";
    }


}