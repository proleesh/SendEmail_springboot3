package org.proleesh.sendemail.annotation;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.IOException;

@WebFilter(filterName = "javaFilter", urlPatterns = "/*",
initParams = {
        @WebInitParam(name="name", value="javaStack"),
        @WebInitParam(name="code", value="123456")
})
@Slf4j
public class JavaFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("java filter init");
        String name = filterConfig.getInitParameter("name");
        String code = filterConfig.getInitParameter("code");
        log.info("name is " + name);
        log.info("code is " + code);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("java filter doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("java filter destroy");
    }
}
