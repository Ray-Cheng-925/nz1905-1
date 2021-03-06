package com.qf.order.v1.consumer.interceptor;

import com.qf.constant.CookieConstant;
import com.qf.constant.RedisConstant;
import com.qf.entity.TUser;
import com.qf.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Ray.Cheng
 * @Date 2020/3/18
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取cookie中的UUID

        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (CookieConstant.USER_LOGIN.equals(cookie.getName())){
                    String uuid = cookie.getValue();
                    String redisKey = StringUtil.getRedisKey(RedisConstant.USER_LOGIN_PRE, uuid);
                    Object o = redisTemplate.opsForValue().get(redisKey);
                    if (o!=null){
                        //用户已经登录
                        TUser user= (TUser) o;
                        //将用户对象存入request域中
                        request.setAttribute("user",user);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
