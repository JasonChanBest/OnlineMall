package com.mall.action.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 陈嘉展
 * @date 2015-01-05 17:04
 * @copyright 版权所有 © 2014 广州合贷投资管理有限公司 www.hedaiwang.cn
 * @since v2.2.0
 */
@Aspect
@Component
public class TestAspect {
    @Around("execution(* com.mall.action.test.TestBean.exec(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("**********************around***************");
        System.out.println("args:" + Arrays.toString(pjp.getArgs()));;
        System.out.println("target:" + pjp.getTarget());
        System.out.println("this:" + pjp.getThis());
        Object result = pjp.proceed();
        System.out.println("result:" + result);
        System.out.println("**********************around***************");
        return result + "改变";
    }
    @Before("execution(* com.mall.action.test.TestBean.exec(..))")
    public void before(JoinPoint jp){
        System.out.println("******************before***************");
        System.out.println("******************before***************");
    }
    @AfterReturning(value = "execution(* com.mall.action.test.TestBean.exec(..))" , returning = "result")
    public void afterReturn(JoinPoint jp , String result){
        System.out.println("******************afterReturn****************");
        System.out.println("result:" + result);
        System.out.println("******************afterReturn****************");
    }
}