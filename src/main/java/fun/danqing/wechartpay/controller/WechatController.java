package fun.danqing.wechartpay.controller;

import fun.danqing.wechartpay.config.WechatConfig;
import fun.danqing.wechartpay.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author 丹青
 * @date 2020/5/9-21:06
 */
@Controller
@RequestMapping("/api/v1/wechat")
public class WechatController {

    @Autowired
    private WechatConfig wechatConfig;

    /**
     * 拼装微信扫一扫登录url
     * @return
     */
    @GetMapping("login_url")
    @ResponseBody
    public JsonData loginUrl(@RequestParam(value = "access_page",required = true)String accessPage) throws UnsupportedEncodingException {
        String redirectUrl = wechatConfig.getOpenRedirectUrl();//获取开放平台重定向地址

        String callbackUrl = URLEncoder.encode(redirectUrl,"GBK");//进行编码

        String qrcodeUrl = String.format(wechatConfig.getOpenQrcodeUrl(),wechatConfig.getOpenAppid(),callbackUrl,accessPage);
        return JsonData.buildSuccess(qrcodeUrl);
    }
}
