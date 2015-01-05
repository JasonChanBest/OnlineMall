package com.mall.action.test;

import org.springframework.stereotype.Component;

/**
 * @author 陈嘉展
 * @date 2015-01-05 17:03
 * @copyright 版权所有 © 2014 广州合贷投资管理有限公司 www.hedaiwang.cn
 * @since v2.2.0
 */
@Component("TestBean")
public class TestBean {
    public String exec(String name){
        System.out.println("TestBean#exec");
        return "hello " + name;
    }
}
