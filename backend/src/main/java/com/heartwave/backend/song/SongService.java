package com.heartwave.backend.song;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class SongService {

	private static final int DEFAULT_LIMIT = 25;

	private final JdbcTemplate jdbcTemplate;

	public SongService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<SongSearchResult> listFirstSongs() {
		return jdbcTemplate.query("""
				SELECT recording_id, recording_mbid, song_title, artist_name, length_ms
				FROM heartwave.song_search_view
				ORDER BY recording_id
				LIMIT ?
				""", songRowMapper(), DEFAULT_LIMIT);
	}

	public List<SongSearchResult> search(String query) {
		return jdbcTemplate.query("""
				SELECT recording_id, recording_mbid, song_title, artist_name, length_ms
				FROM heartwave.song_search_view
				WHERE song_title ILIKE ?
				   OR artist_name ILIKE ?
				ORDER BY recording_id
				LIMIT ?
				""", songRowMapper(), "%" + query + "%", "%" + query + "%", DEFAULT_LIMIT);
	}

	private RowMapper<SongSearchResult> songRowMapper() {
		return SongService::mapSong;
	}

	private static SongSearchResult mapSong(ResultSet rs, int rowNum) throws SQLException {
		return new SongSearchResult(
				rs.getLong("recording_id"),
				rs.getObject("recording_mbid", UUID.class),
				rs.getString("song_title"),
				rs.getString("artist_name"),
				(Integer) rs.getObject("length_ms"));
	}
}
