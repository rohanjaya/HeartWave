package com.heartwave.backend.health;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class AppHealthController {

	@GetMapping
	public AppHealthResponse health() {
		return new AppHealthResponse("ok", "heartwave-backend", Instant.now());
	}
}
