package cn.keep.coding.push.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude={
		RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class,
		MongoAutoConfiguration.class, MongoDataAutoConfiguration.class
})
@ComponentScan("cn.keep.coding")
@ServletComponentScan
public class KeepCodingProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeepCodingProviderApplication.class, args);
	}

}
