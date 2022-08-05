package br.com.alura.forum.config.swagger;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import javax.servlet.ServletContext;
import java.util.Optional;

@Configuration
public class SpringfoxConfig {
//    @Bean
//    public InitializingBean removeSpringfoxHandlerProvider(DocumentationPluginsBootstrapper bootstrapper) {
//        return () -> bootstrapper.getHandlerProviders().removeIf(WebMvcRequestHandlerProvider.class::isInstance);
//    }
//
//    @Bean
//    public RequestHandlerProvider customRequestHandlerProvider(Optional<ServletContext> servletContext, HandlerMethodResolver methodResolver, List<RequestMappingInfoHandlerMapping> handlerMappings) {
//        String contextPath = servletContext.map(ServletContext::getContextPath).orElse(ROOT);
//        return () -> handlerMappings.stream()
//                .filter(mapping -> !mapping.getClass().getSimpleName().equals("IntegrationRequestMappingHandlerMapping"))
//                .map(mapping -> mapping.getHandlerMethods().entrySet())
//                .flatMap(Set::stream)
//                .map(entry -> new WebMvcRequestHandler(contextPath, methodResolver, tweakInfo(entry.getKey()), entry.getValue()))
//                .sorted(byPatternsCondition())
//                .collect(toList());
//    }
//
//    RequestMappingInfo tweakInfo(RequestMappingInfo info) {
//        if (info.getPathPatternsCondition() == null) return info;
//        String[] patterns = info.getPathPatternsCondition().getPatternValues().toArray(String[]::new);
//        return info.mutate().options(new RequestMappingInfo.BuilderConfiguration()).paths(patterns).build();
//    }
}
