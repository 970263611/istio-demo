package istio.mvc;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dahua
 * @time 2022/4/21 13:36
 */
@Component
public class RequestHeaderFilter implements RequestInterceptor {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            requestTemplate.header("color",threadLocal.get());
        } finally {
            threadLocal.remove();
        }
    }
}