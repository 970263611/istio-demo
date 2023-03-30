package istio.mvc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author dahua
 * @time 2023/3/22 11:12
 */
@FeignClient(name = "mvc", url = "${service.address}")
public interface IstioService {

    @RequestMapping(value = "/istio-test-service")
    Map test();
}
