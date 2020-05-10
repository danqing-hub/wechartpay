package fun.danqing.wechartpay.controller;

import fun.danqing.wechartpay.config.WechatConfig;
import fun.danqing.wechartpay.domain.Video;
import fun.danqing.wechartpay.mapper.VideoMapper;
import fun.danqing.wechartpay.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

/**
 * @author 丹青
 * @date 2020/5/3-22:10
 */
@RestController
public class TestController {

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    VideoMapper videoMapper;

    @RequestMapping("/test")
    public JsonData testConfig(){
        System.out.println("daniqng.fun");
        return JsonData.buildSuccess(wechatConfig.getAppId());
    }
    @RequestMapping("/test_db")
    public Object testDB(){
        System.out.println("daniqng.fun");
        return videoMapper.findAll();

    }
}
