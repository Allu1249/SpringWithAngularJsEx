package com.employee.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "co.sample")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/ui/**").addResourceLocations("/ui/");
	}

	@Bean
	public static MappingJacksonHttpMessageConverter getMappingJacksonHttpMessageConverter() {
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();

		MediaType jsonMediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
		MediaType htmlMediaType = new MediaType("text", "html", Charset.forName("UTF-8"));

		supportedMediaTypes.add(jsonMediaType);
		supportedMediaTypes.add(htmlMediaType);

		MappingJacksonHttpMessageConverter jacksonConverter = new MappingJacksonHttpMessageConverter();
		jacksonConverter.setSupportedMediaTypes(supportedMediaTypes);
		return jacksonConverter;

	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new org.springframework.web.servlet.view.InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(getMappingJacksonHttpMessageConverter());
		return messageConverters;
	}

}
