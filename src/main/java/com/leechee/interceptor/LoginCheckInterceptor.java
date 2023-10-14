package com.leechee.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSONObject;
import com.leechee.pojo.Result;
import com.leechee.utils.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
            throws Exception {

        // 1. 获取url
        String url = req.getRequestURL().toString();
        log.info("请求的url为: {}", url);

        // // 2. 判断请求的url是否包含login，若包含则放行 使用拦截器已经在配置中省略了login，此处不再需要额外判断
        // if (url.contains("login")) {
        //     log.info("登录操作，放行");
        //     return true;
        // }

        // 3. 获取请求头的令牌 token
        String jwt = req.getHeader("token");

        // 4. 判断 jwt 令牌是否存在，不存在则返回 未登录 结果
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        // 5. 校验 jwt 令牌，不合法则返回 未登录 结果
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("令牌解析失败，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        // 6. 放行
        log.info("令牌检验通过，放行");
        return true;
    }

}
