package antoniosantos.rest.filters;

import lombok.Data;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class MDCFilterConfig {
    public static final String DEFAULT_RESPONSE_TOKEN_HEADER = "Response-Token";
    public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "MDCFilter.UUID";
    public static final String DEFAULT_MDC_CLIENT_IP_KEY = "MDCFilter.ClientIP";

    @Bean
    public FilterRegistrationBean<MDCFilter> servletRegistrationBean() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        final MDCFilter log4jMDCFilter = new MDCFilter(DEFAULT_RESPONSE_TOKEN_HEADER, DEFAULT_MDC_UUID_TOKEN_KEY, DEFAULT_MDC_CLIENT_IP_KEY, null);
        registrationBean.setFilter(log4jMDCFilter);
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
