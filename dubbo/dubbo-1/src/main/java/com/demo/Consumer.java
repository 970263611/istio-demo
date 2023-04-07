package com.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dahua
 * @time 2023/4/7 10:28
 */
@RestController
public class Consumer {

    /**
     * 配合动态调整生产者地址改造
     * @param address
     */
    public Consumer(@Value("${dubbo.service.address}") String address) {
        String[] split = address.split(";");
        for (String s : split) {
            String name = s.split("-")[0];
            String addr = s.split("-")[1];
            System.setProperty(name, addr);
        }
    }

    @Autowired // 正常使用
    @Reference(url = "localhost:3009") //显示的指定生产者地址，dubbo这个注解的url参数不支持动态读取spring配置文件
    private UserService userService;

    @RequestMapping("/dubbo-health")
    public String health() {
        return "health";
    }

    @RequestMapping("/dubbo-send")
    public String send() {
        return userService.getUser();
    }
}
