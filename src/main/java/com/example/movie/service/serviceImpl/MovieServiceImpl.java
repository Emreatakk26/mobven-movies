package com.example.movie.service.serviceImpl ;

import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.InputStreamReader ;
import java.net.HttpURLConnection ;
import java.net.URL ;
import java.util.ArrayList ;
import java.util.List ;

import org.json.JSONArray ;
import org.json.JSONException ;
import org.json.JSONObject ;
import org.springframework.cache.annotation.CachePut ;
import org.springframework.stereotype.Service ;

import com.example.movie.domain.Movie ;
import com.example.movie.service.MovieService ;

@Service
public class MovieServiceImpl implements MovieService
{
    @Override
    @CachePut( "movie" )
    public List<Movie> getMovieSearchContent( String s )
    {
        System.out.println( "api calisti" ) ;
        String response = null ;
        List<Movie> movieList = new ArrayList<>( ) ;
        try
        {

            URL url = new URL( "http://www.omdbapi.com/?apikey=73e15df0&s=" + s ) ;
            HttpURLConnection conn = ( HttpURLConnection )url.openConnection( ) ;
            conn.setRequestMethod( "GET" ) ;
            conn.setRequestProperty( "Accept", "application/json" ) ;

            if( conn.getResponseCode( ) != 200 )
            {
                throw new RuntimeException( "Failed : HTTP error code : " + conn.getResponseCode( ) ) ;
            }

            BufferedReader br = new BufferedReader( new InputStreamReader( ( conn.getInputStream( ) ) ) ) ;

            String output ;
            System.out.println( "Output from Server .... \n" ) ;
            while( ( output = br.readLine( ) ) != null )
            {
                response = output ;
            }

            conn.disconnect( ) ;

            JSONArray ja = new JSONObject( response.toString( ) ).getJSONArray( "Search" ) ;
            for( int i = 0; i < ja.length( ); i++ )
            {
                JSONObject jo = ( JSONObject )ja.get( i ) ;

                String title = ( String )jo.get( "Title" ) ;
                String year = ( String )jo.get( "Year" ) ;
                String type = ( String )jo.get( "Type" ) ;
                String imdbID = ( String )jo.get( "imdbID" ) ;
                String poster = ( String )jo.get( "Poster" ) ;

                Movie movie = new Movie( title, year, type, imdbID, poster ) ;

                System.err.println( movie ) ;
                movieList.add( movie ) ;

            }

        }
        catch( JSONException | IOException e )
        {
            e.printStackTrace( ) ;
        }

        return movieList ;
    }

}
