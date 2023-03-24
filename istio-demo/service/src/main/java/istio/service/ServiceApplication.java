package istio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/istio-test-service")
    public Map test() {
        System.out.println("color = " + request.getHeader("color"));
        return new HashMap() {{
            put("username", "丁伟强");
            put("age", 27);
            put("sex", "男");
            put("version", System.getProperty("version","default"));
            put("color", request.getHeader("color"));
        }};
    }

    @RequestMapping("/health")
    public String health(){
        return "success";
    }
}
