package io.coder.moviestreamingservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-catalog-service")
public interface MovieInfoClient {

    @GetMapping("/movie-info/find-path-by-id/{movieInfoId}")
    String findPathById(@PathVariable Long movieInfoId);
}
