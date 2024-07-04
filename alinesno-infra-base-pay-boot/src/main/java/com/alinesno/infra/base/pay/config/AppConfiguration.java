package com.alinesno.infra.base.pay.config;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.alinesno.infra.common.web.log.aspect.LogAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 项目配置
 */
@EnableActable
@MapperScan("com.alinesno.infra.base.pay.mapper")
@EnableInfraSsoApi
@Configuration
public class AppConfiguration {

    @Bean
    public LogAspect getLogAspect(){
        return new LogAspect() ;
    }

}
