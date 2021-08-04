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

    @Bean
    public FilterRegistrationBean<MDCFilter> servletRegistrationBean() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean(); // filter for every request (catched before the controller)
        final MDCFilter log4jMDCFilter = new MDCFilter(DEFAULT_RESPONSE_TOKEN_HEADER, DEFAULT_MDC_UUID_TOKEN_KEY, null);
        registrationBean.setFilter(log4jMDCFilter);
        registrationBean.setOrder(2); //2nd servlet filter?
        return registrationBean;
    }
}
