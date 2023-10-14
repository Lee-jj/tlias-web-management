package com.leechee.filter;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.leechee.pojo.Result;
import com.leechee.utils.JwtUtils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class loginCheckFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 1. 获取url
        String url = req.getRequestURL().toString();
        log.info("请求的url为: {}", url);

        // 2. 判断请求的url是否包含login，若包含则放行
        if (url.contains("login")) {
            log.info("登录操作，放行");
            chain.doFilter(request, response);
            return;
        }

        // 3. 获取请求头的令牌 token
        String jwt = req.getHeader("token");

        // 4. 判断 jwt 令牌是否存在，不存在则返回 未登录 结果
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
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
            return;
        }

        // 6. 放行
        log.info("令牌检验通过，放行");
        chain.doFilter(request, response);
        
    }
    
}
