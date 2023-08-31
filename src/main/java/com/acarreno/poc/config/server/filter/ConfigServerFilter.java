package com.acarreno.poc.config.server.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.acarreno.poc.config.server.model.Property;
import com.acarreno.poc.config.server.model.PropertySource;
import com.acarreno.poc.config.server.util.ByteArrayPrinter;
import com.acarreno.poc.config.server.util.EncriptorUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Component
public class ConfigServerFilter implements Filter {

  @Autowired
  private EncriptorUtil encriptorUtil;

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    ByteArrayPrinter pw = new ByteArrayPrinter();


    HttpServletResponse wrappedResp = new HttpServletResponseWrapper(response) {

      @Override
      public void setContentType(final String type) {
        super.setContentType("application/json;charset=UTF-8");
      }

      @Override
      public PrintWriter getWriter() {
        return pw.getWriter();
      }

      @Override
      public ServletOutputStream getOutputStream() throws IOException {
        return pw.getStream();
      }
    };

    chain.doFilter(request, wrappedResp);

    byte[] bodyResponse = pw.toByteArray();

    Property property = getProperty(bodyResponse);

    if (null != property) {

      Map<String, String> prop = null;

      for (PropertySource item : property.getPropertySources()) {

        prop = new HashMap<>();

        for (Map.Entry<String, String> entry : item.getSource().entrySet()) {
          prop.put(entry.getKey(), encriptorUtil.decrypt(entry.getValue()));
        }

        item.setSource(prop);
      }

      ObjectMapper mapper = new ObjectMapper();

      response.getOutputStream().write(mapper.writeValueAsBytes(property));

    } else {
      response.getOutputStream().write(bodyResponse);
    }

  }

  private Property getProperty(byte[] body) {

    try {

      Gson gson = new Gson();
      return gson.fromJson(new String(body), Property.class);

    } catch (Exception e) {
      return null;
    }

  }

}
