package com.example.springsecuritychpt2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


	/**
	 * <br>
	 * curl http://localhost:8080/hello<br>
	 * cmd에서 위의 결과로 아무것도 안나온다면 -v 옵션으로 더 상세한 결과 출력 가능<br>
	 * curl http://localhost:8080/hello -v<br>
	 * <br>
	 * Spring 서버 시작되면서 출력되는 아래의 로그를 바탕으로 password 획득 <br>
	 * Using generated security password: f985a947-ea8a-4807-b353-026f464b08a1<br>
	 * <br>
	 * curl -u user:6857e9ed-1980-438d-ab06-216551858c2f http://localhost:8080/hello<br>
	 * curl -u user:6857e9ed-1980-438d-ab06-216551858c2f http://localhost:8080/hello -v<br>
	 * <br>
	 * echo -n user:6857e9ed-1980-438d-ab06-216551858c2f | base64  명령어로 base64 로 변환가능<br>
	 * 결과 : dXNlcjo2ODU3ZTllZC0xOTgwLTQzOGQtYWIwNi0yMTY1NTE4NThjMmY=<br>
	 * <br>
	 * curl -H "Authorization: Basic dXNlcjo2ODU3ZTllZC0xOTgwLTQzOGQtYWIwNi0yMTY1NTE4NThjMmY" http://localhost:8080/hello<br>
	 * <br>
	 * 위의 user:6857e9ed-1980-438d-ab06-216551858c2f 를 사용했을때와 동일하게 나오는것 확인 가능
	 *
	 */
	@SuppressWarnings("JavadocLinkAsPlainText")
	@GetMapping("/hello")
	public String hello(){
		return "Hello!";
	}
}
