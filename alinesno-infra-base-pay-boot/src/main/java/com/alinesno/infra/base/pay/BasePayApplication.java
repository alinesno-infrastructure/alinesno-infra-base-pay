package com.alinesno.infra.base.pay;

import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.egzosn.pay.spring.boot.core.MerchantPayServiceManager;
import com.egzosn.pay.spring.boot.core.PayServiceManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@EnableInfraSsoApi
@SpringBootApplication
public class BasePayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasePayApplication.class, args);
	}

}