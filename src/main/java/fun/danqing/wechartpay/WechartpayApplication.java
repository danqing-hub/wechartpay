package fun.danqing.wechartpay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("fun.danqing.wechartpay.mapper")
public class WechartpayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechartpayApplication.class, args);
    }

}
