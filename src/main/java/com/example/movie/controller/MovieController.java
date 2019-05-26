package com.example.movie.controller ;

import java.util.List ;

import javax.validation.Valid ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.web.bind.annotation.GetMapping ;
import org.springframework.web.bind.annotation.PathVariable ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RestController ;

import com.example.movie.domain.Movie ;
import com.example.movie.repository.MovieRepository ;
import com.example.movie.service.MovieService ;

@RestController
@RequestMapping( "/s" )
//@EnableResourceServer
public class MovieController
{

    @Autowired
    protected MovieService movieService ;

    @Autowired
    protected MovieRepository movieRepository ;

    @GetMapping( "/movie/{title}" )
    public List<Movie> findmovieByTitle( @PathVariable String title )
    {
        System.out.println( "Searching by TITLE  : " + title ) ;

        List<Movie> cacheMovie = movieRepository.getByTitle( title ) ;
        if( cacheMovie.size( ) > 0 )
        {
            System.out.println( "cacheden geldi" ) ;
            return cacheMovie ;
        }
        else
        {
            System.out.println( "db calisti" ) ;
            List<Movie> dbMovie = movieRepository.findByTitle( title ) ;
            if( dbMovie.size( ) > 0 )
            {
                return dbMovie ;
            }
            else
            {
                List<Movie> restMovie = movieService.getMovieSearchContent( title ) ;
                movieRepository.saveAll( restMovie ) ;
                return restMovie ;
            }
        }
    }

    @GetMapping( "/m_movie" )
    public List<Movie> getAllMovies( )
    {
        return movieRepository.findAll( ) ;
    }

    @PostMapping( "/m_movie" )
    public Movie createmovie( @Valid @RequestBody Movie movie )
    {
        return movieRepository.save( movie ) ;
    }
}
