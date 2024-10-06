package io.coder.moviestreamingservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/stream")
@Slf4j
public class MovieStreamController {

    private static final String FILE_PREFIX = "/home/coder/videos/";

    @Autowired
    private MovieCatalogService movieCatalogService;

    @GetMapping("/{moviePath}")
    public ResponseEntity<InputStreamResource>  streamVideo(@PathVariable String moviePath) throws FileNotFoundException {
        File videoFile = new File(FILE_PREFIX + moviePath);
        if(!videoFile.exists()) return ResponseEntity.notFound().build();
        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(videoFile));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("video/mp4"))
                .body(inputStreamResource);
    }

    @GetMapping("/with-id/{movieId}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable Long movieId) throws FileNotFoundException {
        String moviePath = movieCatalogService.getMoviePath(movieId);
        log.info("Resolved movie path = {} ", moviePath);
        return streamVideo(moviePath);
    }
}
