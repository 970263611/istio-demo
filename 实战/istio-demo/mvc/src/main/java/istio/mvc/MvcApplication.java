package istio.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableFeignClients
@RestController
public class MvcApplication {

    @Autowired
    private IstioService istioService;

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

    @RequestMapping("/")
    public String test(@RequestParam String color) {
        RequestHeaderFilter.threadLocal.set(color);
        return istioService.test().toString();
    }

    @RequestMapping("/health")
    public String health(){
        return "success";
    }

    @RequestMapping("headerTest")
    public String headerTest(HttpServletRequest request){
        return request.getHeader("test-header");
    }

    @RequestMapping("paramTest")
    public String paramTest(HttpServletRequest request){
        return "success - " + request.getHeader("test-header");
    }
}
