package com.alinesno.infra.base.pay.channel.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>IJPay 让支付触手可及，封装了微信支付、支付宝支付、银联支付常用的支付方式以及各种常用的接口。</p>
 *
 * <p>不依赖任何第三方 mvc 框架，仅仅作为工具使用简单快速完成支付模块的开发，可轻松嵌入到任何系统里。 </p>
 *
 * <p>IJPay 交流群: </p>
 *
 * <p>Node.js 版: <a href="https://gitee.com/javen205/TNWX">https://gitee.com/javen205/TNWX</a></p>
 *
 * <p>微信配置 Bean</p>
 *
 * @author Javen
 */
@Data
@Component
//@PropertySource("classpath:/wxpay.properties")
@ConfigurationProperties(prefix = "wxpay")
public class WxPayBean {

	private String appId;
	private String appSecret;
	private String mchId;
	private String partnerKey;
	private String certPath;
	private String domain;

	@Override
	public String toString() {
		return "WxPayBean [appId=" + appId + ", appSecret=" + appSecret + ", mchId=" + mchId + ", partnerKey="
			+ partnerKey + ", certPath=" + certPath + ", domain=" + domain + "]";
	}
}
