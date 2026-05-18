package com.heartwave.backend.root;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String root() {
		return """
				<!doctype html>
				<html lang="en">
				<head>
					<meta charset="utf-8">
					<meta name="viewport" content="width=device-width, initial-scale=1">
					<title>HeartWave</title>
				</head>
				<body>
					<img src="/logo.png" alt="HeartWave logo">
				</body>
				</html>
				""";
	}
}
