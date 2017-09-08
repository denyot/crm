package com.hu.crm.util;

import javax.servlet.http.HttpServletRequest;

public class UserContext {
    public final static String USERINSESSION = "USER_IN_SESSION";
    public static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal();

    public static void set(HttpServletRequest request) {
        threadLocal.set(request);
    }

    public static HttpServletRequest get() {
        return threadLocal.get();
    }
}
