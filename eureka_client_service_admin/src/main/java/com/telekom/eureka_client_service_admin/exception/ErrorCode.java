package com.telekom.eureka_client_service_admin.exception;

public enum ErrorCode {
    LOGIN_NOT_UNIQUE(1, "User with same name already exist in system. Try again"),
    USER_NOT_FOUND(2, "User not found. Something went wrong"),
    EMPTY_ROLE(3, "You must select for user role. Try again"),
    EMPTY_PARAMS(4, "You not chose some params, so we couldn't execute."),
    USERNAME_NOT_UNIQUE(5, "User with same username already exist in system. Try again.");

    private int code;
    private String reason;

    ErrorCode(int i, String s) {
        code = i;
        reason = s;
    }

    public String getMessage() {
        return String.format("[CODE]: %d, [MESSAGE]: %s", code, reason);
    }
}