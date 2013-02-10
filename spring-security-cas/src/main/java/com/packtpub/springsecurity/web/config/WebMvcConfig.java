package com.packtpub.springsecurity.web.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
 * <p>
 * Here we leverage Spring 3.1's {@link EnableWebMvc} support. This allows more powerful configuration but still be
 * concise about it. Specifically it allows overriding {@link #requestMappingHandlerMapping()}. Note that this class is
 * loaded via the mvc-config.xml
 * </p>
 * <p>
 * You can find a fairly equivalent Spring MVC configuration below:
 * </p>
 *
 * <pre>
 * &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
 * &lt;beans xmlns=&quot;http://www.springframework.org/schema/beans&quot;
 *     xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot;
 *     xmlns:p=&quot;http://www.springframework.org/schema/p&quot;
 *     xmlns:context=&quot;http://www.springframework.org/schema/context&quot;
 *     xmlns:mvc=&quot;http://www.springframework.org/schema/mvc&quot;
 *     xsi:schemaLocation=&quot;http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.1.xsd
 *         http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
 *         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd&quot;&gt;
 *
 *     &lt;mvc:annotation-driven/&gt;
 *     &lt;mvc:resources location=&quot;/resources/&quot; mapping=&quot;/resources/**&quot; cache-period=&quot;31556926&quot;/&gt;
 *     &lt;context:component-scan base-package=&quot;com.packtpub.springsecurity.web.controllers&quot;/&gt;
 *
 *     &lt;bean class=&quot;org.springframework.web.servlet.view.ContentNegotiatingViewResolver&quot;&gt;
 *         &lt;property name=&quot;mediaTypes&quot;&gt;
 *             &lt;map&gt;
 *                 &lt;entry key=&quot;json&quot; value=&quot;application/json&quot;/&gt;
 *             &lt;/map&gt;
 *         &lt;/property&gt;
 *         &lt;property name=&quot;defaultViews&quot;&gt;
 *             &lt;list&gt;
 *                 &lt;bean class=&quot;org.springframework.web.servlet.view.json.MappingJacksonJsonView&quot;
 *                     p:extractValueFromSingleKeyModel=&quot;true&quot;
 *                     p:modelKeys=&quot;#{{'events','event'}}&quot;/&gt;
 *             &lt;/list&gt;
 *         &lt;/property&gt;
 *     &lt;/bean&gt;
 *     &lt;bean class=&quot;org.springframework.web.servlet.view.InternalResourceViewResolver&quot;&gt;
 *         &lt;property name=&quot;prefix&quot; value=&quot;/WEB-INF/views/&quot;/&gt;
 *         &lt;property name=&quot;suffix&quot; value=&quot;.jsp&quot;/&gt;
 *     &lt;/bean&gt;
 * &lt;/beans&gt;
 * </pre>
 *
 * @author Rob Winch
 *
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * We mention this in the book, but this helps to ensure that the intercept-url patterns prevent access to our
     * controllers. For example, once security has been applied for administrators try commenting out the modifications
     * to the super class and requesting <a
     * href="http://localhost:800/calendar/events/.html">http://localhost:800/calendar/events/.html</a>. You will
     * observe that security is bypassed since it did not match the pattern we provided. In later chapters, we discuss
     * how to secure the service tier which helps mitigate bypassing of the URL based security too.
     */
    @Bean
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping result = super.requestMappingHandlerMapping();
        result.setUseSuffixPatternMatch(false);
        result.setUseTrailingSlashMatch(false);
        return result;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    }

    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver result = new ContentNegotiatingViewResolver();
        Map<String, String> mediaTypes = new HashMap<String, String>();
        mediaTypes.put("json", MediaType.APPLICATION_JSON_VALUE);
        result.setMediaTypes(mediaTypes);
        MappingJacksonJsonView jacksonView = new MappingJacksonJsonView();
        jacksonView.setExtractValueFromSingleKeyModel(true);
        Set<String> modelKeys = new HashSet<String>();
        modelKeys.add("events");
        modelKeys.add("event");
        jacksonView.setModelKeys(modelKeys);
        result.setDefaultViews(Collections.singletonList((View) jacksonView));
        return result;
    }

    @Bean
    public InternalResourceViewResolver internalResolver() {
        InternalResourceViewResolver internalResolver = new InternalResourceViewResolver();
        internalResolver.setPrefix("/WEB-INF/views/");
        internalResolver.setSuffix(".jsp");
        return internalResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/login/form")
                .setViewName("login");
        registry.addViewController("/errors/403")
                .setViewName("/errors/403");
    }
}
