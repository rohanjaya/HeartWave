package com.heartwave.backend.health;

import java.time.Instant;

public record AppHealthResponse(String status, String service, Instant timestamp) {
}
