package io.coder.moviecatalogservice.dao;

import io.coder.moviecatalogservice.model.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoDao extends JpaRepository<MovieInfo, Long> {
}
