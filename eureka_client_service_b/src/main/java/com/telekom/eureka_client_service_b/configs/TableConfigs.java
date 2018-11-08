package com.telekom.eureka_client_service_b.configs;

public class TableConfigs {

    private TableConfigs() {
        throw new IllegalStateException("Configs classes");
    }

    public static final String SCHEMA = "public";
    public static final String TABLE_USER_DETAIL = "user_auth";
    public static final String TABLE_USER_DETAIL_COLUMN_ID = "id";
    public static final String TABLE_USER_DETAIL_COLUMN_NAME = "user_name";
    public static final String TABLE_USER_DETAIL_COLUMN_NUMBER = "user_number";
    public static final String TABLE_USER_DETAIL_SEQUENCE = "user_id_seq";

    public static final String TABLE_ROLE = "roles";
    public static final String TABLE_ROLE_ID = "id";
    public static final String TABLE_ROLE_NAME = "role";
    public static final String TABLE_ROLE_SEQUENCE = "roles_id_seq";

    public static final String TABLE_SERVICE = "tservice";
    public static final String TABLE_SERVICE_ID = "id";
    public static final String TABLE_SERVICE_NAME = "service";
    public static final String TABLE_SERVICE_SEQUENCE = "service_id_seq";

    public static final String TABLE_CREDENTIALS = "credentials";
    public static final String TABLE_CREDENTIALS_COLUMN_ID = "id";
    public static final String TABLE_CREDENTIALS_COLUMN_LOGIN = "user_login";
    public static final String TABLE_CREDENTIALS_COLUMN_PASS = "user_password";
    public static final String TABLE_CREDENTIALS_SEQUENCE = "credentials_id_seq";

    /**
     * ACCESS: ID, ACCESS_NAME, TYPE_ACCESS_ID, SERVICE_ID
     */
    public static final String TABLE_ACCESS = "access";
    public static final String TABLE_ACCESS_COLUMN_ID = "id";
    public static final String TABLE_ACCESS_COLUMN_NAME = "access_name";
    public static final String TABLE_ACCESS_SEQUENCE = "opportunities_id_seq";

    public static final String TABLE_USER_DETAIL_ROLE = "user_roles";
    public static final String TABLE_USER_DETAIL_ROLE_COLUMN_USER_DETAIL = "user_auth_id";
    public static final String TABLE_USER_DETAIL_ROLE_COLUMN_ROLE = "role_id";

    /**
     * JOIN ACCESS AND ROLE TABLES
     */
    public static final String TABLE_ROLE_ACCESS = "role_access";
    public static final String TABLE_ROLE_ACCESS_COLUMN_USER_DETAIL = "role_id";
    public static final String TABLE_ROLE_ACCESS_COLUMN_OPPORTUNITY = "access_id";

    /**
     * TYPE ACCESS: ID, ACCESS
     */
    public static final String TABLE_TYPE_ACCESS = "type_access";
    public static final String TABLE_TYPE_ACCESS_ID = "id";
    public static final String TABLE_TYPE_ACCESS_NAME = "access";
    public static final String TABLE_TYPE_ACCESS_SEQUENCE = "type_access_id_seq";

    public static final String GENERATOR = "auto-gen";
}
