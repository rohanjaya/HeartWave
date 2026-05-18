package com.heartwave.backend.song;

import java.util.UUID;

public record SongSearchResult(
		long recordingId,
		UUID recordingMbid,
		String songTitle,
		String artistName,
		Integer lengthMs) {
}
