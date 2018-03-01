package com.zeng.utils.cache;


import com.zeng.utils.data.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * class_name: CookieUtils
 * package: com.zhaogang.tools.utils
 * describe: 缓存操作工具类
 * creat_user: yangsheng.zeng
 * creat_date: 2017/12/12
 * creat_time: 16:21
 **/
public class CookieUtils {
    /**
     * 添加cookie，不带domain
     *
     * @param response
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期(以秒为单位)
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        addCookie(response, name, value, null, maxAge);
    }

    /**
     * 添加cookie，带domain
     *
     * @param response
     * @param name     cookie名字
     * @param value    cookie值
     * @param domain   cookie作用域
     * @param maxAge   cookie生命周期(以秒为单位)
     */
    public static void addCookie(HttpServletResponse response, String name, String value, String domain, int maxAge) {
        try {
            if (value != null) {
                value = URLEncoder.encode(value, "utf-8");
            } else {
                value = "";
            }
        } catch (UnsupportedEncodingException e) {
            value = "";
        }
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (StringUtils.isNotBlank(domain)) {
            cookie.setDomain(domain);
        }
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    /**
     * 删除cookie
     *
     * @param request
     * @param response
     * @param name
     */
    public static void delCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

    /**
     * 修改cookie
     *
     * @param request
     * @param response
     * @param name
     * @param value
     */
    public static void editCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int maxAge) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue(value);
                    cookie.setPath("/");
                    cookie.setMaxAge(maxAge);
                    response.addCookie(cookie);
                    break;
                }
            }
        }

    }

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name    cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
