package com.telekom.eureka_client_service_admin.controller;


import com.telekom.eureka_client_service_admin.utils.URLs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewController {

    @RequestMapping(value = URLs.URL_VIEW_ADMIN)
    public String getAdminPage() {
        return URLs.VIEW_ADMIN;
    }

    @RequestMapping(value = URLs.URL_VIEW_LOGIN)
    public String getLoginPage() {
        return URLs.VIEW_LOGIN;
    }
}
