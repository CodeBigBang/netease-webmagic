package com.album100.webmagic;

import com.album100.webmagic.pipeline.NetEaseMusicPipeline;
import com.album100.webmagic.processor.NetEaseMusicPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WebmagicApplication {

	@Autowired
	NetEaseMusicPageProcessor mProcessor;

	@Autowired
	NetEaseMusicPipeline mPipeline;

	@GetMapping("/")
	public String starting() {
		new Thread(() -> mProcessor.start(mProcessor, mPipeline)).start();
		return "爬 虫 开 启";
	}

	public static void main(String[] args) {
		SpringApplication.run(WebmagicApplication.class, args);
	}
}
