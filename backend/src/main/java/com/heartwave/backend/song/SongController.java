package com.heartwave.backend.song;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/songs")
public class SongController {

	private final SongService songService;

	public SongController(SongService songService) {
		this.songService = songService;
	}

	@GetMapping
	public List<SongSearchResult> list() {
		return songService.listFirstSongs();
	}

	@GetMapping("/search")
	public List<SongSearchResult> search(
			@RequestParam("q") @NotBlank @Size(max = 200) String query) {
		return songService.search(query);
	}
}
