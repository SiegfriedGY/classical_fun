package com.gengyu.classicalfun.repository;

import com.gengyu.classicalfun.dict.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenreRepository extends JpaRepository<Genre, Integer>{

    @Query(value = "select g.genre_name from dict_genre g where g.genre_number = ?1",
            nativeQuery = true)
    String queryGenreNameByGenreNumber(Integer number);

}
