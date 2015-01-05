package com.mall.action.test;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 陈嘉展
 * @date 2015-01-05 17:02
 * @copyright 版权所有 © 2014 广州合贷投资管理有限公司 www.hedaiwang.cn
 * @since v2.2.0
 */
@Controller
@RequestMapping("/mytest")
public class MyTest {
    @Autowired
    TestBean bean;
    @RequestMapping("/test")
    public void test(){
        String result = bean.exec("中国");
        System.out.println("#######test result:" + result + "##########");
    }
}
