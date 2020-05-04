package com.hongsu.springwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//스프링 부트의 자동설정, 스프링  bean읽기와 생성을 모두 자동으로 설정
//@springbootApplication이 있는 위치부터 설정을 읽어가기 떄문에 항상 프로젝트 최상단에 위치
@SpringBootApplication
public class SpringWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebserviceApplication.class, args);
	}

}
