package com.telekom.eureka_client_service_admin.utils;

public class URLs {

    public final static String URL_API = "/admin/tool";

    public final static String URL_POST_USER = "/add";

    public final static String URL_DELETE_USER_BY_LOGIN = "/delete/login/{userName}";

    public final static String URL_DELETE_USER_BY_USERNAME = "/delete/name/{userName}";

    public final static String URL_GET_ACCESS = "/opportunities";

    public final static String URL_PUT_ACCESSES = "/grant";

    public final static String URL_GET_USERS = "/users";

    public final static String URL_GET_USERS_USERNAME = "/get/detail";

    public final static String URL_GET_USERS_LOGIN = "/get/login";

    public final static String URL_GET_ROLES = "/roles";

    public final static String URL_GET_ACCESSES_BY_ROLE = "/access/{role}";

    public final static String URL_GET_SERVICES = "/services";

    public final static String URL_GET_SERVICE_TYPES = "/types";

    public final static String URL_POST_ACCESS = "/addAccess";

    public final static String URL_VIEW_ADMIN = "/admin";

    public final static String URL_VIEW_LOGIN = "/login";

    public final static String VIEW_LOGIN = "login";

    public final static String VIEW_ADMIN = "admin";

}
