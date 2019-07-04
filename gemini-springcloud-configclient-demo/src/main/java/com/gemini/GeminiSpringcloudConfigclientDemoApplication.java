package com.gemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

@SpringBootApplication
public class GeminiSpringcloudConfigclientDemoApplication {

	private final ContextRefresher contextRefresher;

	@Autowired
	public GeminiSpringcloudConfigclientDemoApplication(ContextRefresher contextRefresher) {
		this.contextRefresher = contextRefresher;
	}

	public static void main(String[] args) {
		SpringApplication.run(GeminiSpringcloudConfigclientDemoApplication.class, args);
	}

	/**
	 * 配置更新
	 */
	@Scheduled(fixedRate = 60*1000,initialDelay = 3*1000)
     public void autoRefresh(){
		System.out.printf("[Tread :%s] 开始执行配置更新........\n",Thread.currentThread().getName());
		Set<String> updateItems = contextRefresher.refresh();
		updateItems.forEach(item->{
			System.out.printf("[Tread :%s] 当前配置已更新，具体项目 %s \n",Thread.currentThread().getName(),item);
		});
		if(!updateItems.isEmpty()){
			System.out.printf("[Tread :%s] 当前配置已更新，项目 %s",Thread.currentThread().getName(),updateItems);
		}
	}


	/**
	 * 自定义系统或业务监控健康指标
	 * @return
	 */
	@Bean("MyHealthIndicator")
	public MyHealthIndicator index() {
		return new MyHealthIndicator();
	}
}
