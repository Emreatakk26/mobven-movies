package com.example.movie.domain ;
import java.io.Serializable ;
import java.util.ArrayList ;
import java.util.Date ;
import java.util.List ;

import javax.persistence.Column ;
import javax.persistence.Entity ;
import javax.persistence.EntityListeners ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.Table ;
import javax.persistence.Temporal ;
import javax.persistence.TemporalType ;
import javax.validation.constraints.NotBlank ;

import org.springframework.data.annotation.CreatedDate ;
import org.springframework.data.annotation.LastModifiedDate ;
import org.springframework.data.jpa.domain.support.AuditingEntityListener ;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties ;

@Entity
@Table( name = "m_movie" )
@EntityListeners( AuditingEntityListener.class )
public class Movie implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -4227563281503207557L ;
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column
    private Long id ;

    @NotBlank
    @Column
    private String title ;

    @NotBlank
    @Column
    private String imdbID ;

    @NotBlank
    @Column
    private String year ;

    @NotBlank
    @Column
    private String type ;

    @NotBlank
    @Column
    private String poster ;

    public Movie( )
    {
    }

    public Movie( String title, String year, String type, String imdbID, String poster )
    {
        super( ) ;
        this.title = title ;
        this.year = year ;
        this.type = type ;
        this.imdbID = imdbID ;
        this.poster = poster ;
    }

    public String getTitle( )
    {
        return title ;
    }

    public void setTitle( String title )
    {
        this.title = title ;
    }

    public String getYear( )
    {
        return year ;
    }

    public void setYear( String year )
    {
        this.year = year ;
    }

    public String getType( )
    {
        return type ;
    }

    public void setType( String type )
    {
        this.type = type ;
    }

    public Long getId( )
    {
        return id ;
    }

    public void setId( Long id )
    {
        this.id = id ;
    }

    public String getImdbID( )
    {
        return imdbID ;
    }

    public void setImdbID( String imdbID )
    {
        this.imdbID = imdbID ;
    }

    public String getPoster( )
    {
        return poster ;
    }

    public void setPoster( String poster )
    {
        this.poster = poster ;
    }

    public static List<Movie> getSampleByTitle( String title )
    {
        List<Movie> movies = new ArrayList<>( ) ;

        return movies ;
    }

}