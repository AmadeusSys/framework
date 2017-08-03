package com.xiangmaikeji.framework.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by TY on 2017/5/1.
 */
@Configuration
@EnableSwagger2
public class Swagger2 extends WebMvcConfigurerAdapter {

    private Docket build;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public Docket v2RestApi() {

        ApiInfo apiInfo =  new ApiInfoBuilder().title("XMSERP Service V1").description("享买科技ERP系统服务端支持").termsOfServiceUrl("http://blog.didispace.com/")
                .version("1.0") .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo).groupName("v1")
                .select()//.paths(demoPaths())
                .apis(RequestHandlerSelectors.basePackage("com.xiangmaikeji.controller.service"))
                .paths(PathSelectors.any())
                .build();

    }



}
