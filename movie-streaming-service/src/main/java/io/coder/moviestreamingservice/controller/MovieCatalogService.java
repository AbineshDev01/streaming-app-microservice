package io.coder.moviestreamingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieCatalogService {

    private static final String CATALOG_SERVICE = "http://movie-catalog-service";

    @Autowired
    private RestTemplate restTemplate;

    public String getMoviePath(Long movieInfoId) {
        ResponseEntity<String> response = restTemplate.getForEntity(CATALOG_SERVICE + "/movie-info/find-path-by-id/{movieInfoId}", String.class, movieInfoId);
        return response.getBody();
    }
}
