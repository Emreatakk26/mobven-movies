package com.example.movie.repository ;
import java.util.List ;

import org.springframework.cache.annotation.CachePut ;
import org.springframework.cache.annotation.Cacheable ;
import org.springframework.data.jpa.repository.JpaRepository ;
import org.springframework.data.jpa.repository.Query ;
import org.springframework.stereotype.Repository ;

import com.example.movie.domain.Movie ;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>
{
    @Cacheable( "movie" )
    public default List<Movie> getByTitle( String title )
    {
        try
        {
            Thread.sleep( 1000 * 5 ) ;
        }
        catch( InterruptedException e )
        {
            e.printStackTrace( ) ;
        }
        return Movie.getSampleByTitle( title ) ;

    }

    @Query("Select m from Movie m where m.title like %:title%")
    @CachePut( "movie" )
    List<Movie> findByTitle( String title ) ;
}