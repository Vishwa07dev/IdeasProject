package com.upgrad.IdeasProject.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.stereotype.Component;


@Component
public class MyCustomFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {

    System.out.println("Inside the filter ");
    System.out.println("Client local address : " +servletRequest.getLocalAddr());

    filterChain.doFilter(servletRequest,servletResponse);

  }

  @Override
  public void destroy() {

  }
}
