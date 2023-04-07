package com.demo;

import com.alibaba.dubbo.config.annotation.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author dahua
 * @time 2023/4/7 10:33
 */
@Service
public class Provider implements UserService {

    @Override
    public String getUser() {
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "主机名：" + localHost.getHostName() + "，本地ip地址：" + localHost.getHostAddress();
    }
}
