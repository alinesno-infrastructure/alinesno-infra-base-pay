package com.alinesno.infra.base.pay.channel.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alinesno.infra.base.pay.channel.interceptor.AliPayInterceptor;
import com.alinesno.infra.base.pay.channel.interceptor.WxPayInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class IJPayConfigurer extends WebMvcConfigurationSupport {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AliPayInterceptor()).addPathPatterns("/aliPay/**");
		registry.addInterceptor(new WxPayInterceptor()).addPathPatterns("/wxPay/**");
		super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 将所有/static/** 访问都映射到classpath:/static/ 目录下
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);

		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(

			SerializerFeature.WriteMapNullValue, // 保留map空的字段

			SerializerFeature.WriteNullStringAsEmpty, // 将String类型的null转成""

			SerializerFeature.WriteNullNumberAsZero, // 将Number类型的null转成0

			SerializerFeature.WriteNullListAsEmpty, // 将List类型的null转成[]

			SerializerFeature.WriteNullBooleanAsFalse, // 将Boolean类型的null转成false


			SerializerFeature.DisableCircularReferenceDetect);// 避免循环引用

		//3.设置Long为字符串
		SerializeConfig serializeConfig = SerializeConfig.globalInstance;
		serializeConfig.put(Long.class, ToStringSerializer.instance);
		serializeConfig.put(Long.TYPE, ToStringSerializer.instance);

		config.setSerializeConfig(serializeConfig);

		converter.setFastJsonConfig(config);
		converter.setDefaultCharset(StandardCharsets.UTF_8);
		List<MediaType> mediaTypeList = new ArrayList<>();
		// 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces = "application/json"
		mediaTypeList.add(MediaType.APPLICATION_JSON);
		converter.setSupportedMediaTypes(mediaTypeList);
		converters.add(converter);

		converters.add(responseBodyConverter());
	}

	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		return new StringHttpMessageConverter(StandardCharsets.UTF_8);
	}
}
