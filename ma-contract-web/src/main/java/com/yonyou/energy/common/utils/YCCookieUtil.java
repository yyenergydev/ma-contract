package com.yonyou.energy.common.utils;

import javax.servlet.http.Cookie;

/**
 * Cookies操作工具类
 */
public class YCCookieUtil {

    public static String get(Cookie[] cookies, String name) {
        if ((cookies != null) && (cookies.length > 0)) {
            for (int i = 0; i < cookies.length; i++) {
                String cookieName = cookies[i].getName();

                if ((cookieName != null) && (cookieName.equals(name))) {
                    return cookies[i].getValue();
                }
            }
        }

        return null;
    }

    public static String get(String cookie, String tag) {
        if (cookie == null) {
            return "";
        }

        tag = tag + "=";

        if (cookie.startsWith(tag)) {
            int y = cookie.indexOf(';');

            return cookie.substring(tag.length(), y);
        }

        tag = ";" + tag;

        int x = cookie.indexOf(tag);

        if (x != -1) {
            int y = cookie.indexOf(';', x + 1);

            return cookie.substring(x + tag.length(), y);
        }

        return "";
    }

    public static String set(String cookie, String tag, String sub) {
        if (cookie == null) {
            return "";
        }

        tag = tag + "=";

        if (cookie.startsWith(tag)) {
            int y = cookie.indexOf(';');

            StringBuffer sb = new StringBuffer();

            sb.append(tag).append(sub).append(";");
            sb.append(cookie.substring(y + 1, cookie.length()));

            return sb.toString();
        }

        tag = ";" + tag;

        int x = cookie.indexOf(tag);

        if (x != -1) {
            int y = cookie.indexOf(';', x + 1);

            StringBuffer sb = new StringBuffer();

            sb.append(cookie.substring(0, x + tag.length()));
            sb.append(sub);
            sb.append(cookie.substring(y, cookie.length()));

            return sb.toString();
        }

        return cookie + tag.substring(1, tag.length()) + sub + ";";
    }

}