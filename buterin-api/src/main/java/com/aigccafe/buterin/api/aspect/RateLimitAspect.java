package com.aigccafe.buterin.api.aspect;

import com.aigccafe.buterin.common.util.SystemUtil;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class RateLimitAspect {
    private final Map<String, RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();


    @Before("@annotation(rateLimit)")
    public void before(JoinPoint joinPoint, RateLimit rateLimit) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String ip = SystemUtil.getIpAddr(request);
        String uri = request.getRequestURI();
        String targetTag = uri + "|" + ip;
        double rate = rateLimit.value();
        //System.out.println("标志：" + targetTag);
        RateLimiter rateLimiter = rateLimiterMap.computeIfAbsent(targetTag, k -> RateLimiter.create(rate));
        if (!rateLimiter.tryAcquire()) {
            throw new Exception("Too many requests");
        }
    }
}

