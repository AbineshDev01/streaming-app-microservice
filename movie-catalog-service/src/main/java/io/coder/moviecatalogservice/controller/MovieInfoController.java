package io.coder.moviecatalogservice.controller;

import io.coder.moviecatalogservice.dao.MovieInfoDao;
import io.coder.moviecatalogservice.model.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie-info")
public class MovieInfoController {

    @Autowired
    private MovieInfoDao movieInfoDao;

    @PostMapping("/save")
    public List<MovieInfo> saveMovieInfo(@RequestBody List<MovieInfo> movieInfoList) {
        return movieInfoDao.saveAll(movieInfoList);
    }

    @GetMapping("/list")
    public List<MovieInfo> getMovieInfoList() {
        return movieInfoDao.findAll();
    }

    @GetMapping("/find-path-by-id/{movieInfoId}")
    public String findPathById(@PathVariable Long movieInfoId) {
        Optional<MovieInfo> movieInfoOptional = movieInfoDao.findById(movieInfoId);
        return movieInfoOptional
                .map(MovieInfo::getPath).orElse(null);
    }
}
