package com.pnpsecure.javapractice.thread;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AsyncController {
	private final restService restService;
	
	@GetMapping("/io")
	public String syncIo() {
		return restService.syncIo();
	}
}

@Slf4j
@Service
@RequiredArgsConstructor
class restService {
	private final JdbcTemplate jdbcTemplate;
	
	public String syncIo() {
		return jdbcTemplate.queryForList("select sleep(1);").toString();
	}
}