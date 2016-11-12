package org.seuge.vetclinic.config.util;

/**
 * Authentication queries and other security-related constants
 *
 * @author Eugene
 * @since 1.0
 */
public final class SecurityConsts {

    /**
     */
    public static final String QUERY_USER_BY_USERNAME = "SELECT login, pass, enabled FROM users WHERE login = ?";
    public static final String QUERY_AUTH_BY_USERNAME = "SELECT u.login, r.name FROM users u LEFT JOIN users_roles ur"
            + " ON u.id = ur.user_id LEFT JOIN roles r ON ur.role_id = r.id WHERE u.login = ?";

    private SecurityConsts() {
    }
}
