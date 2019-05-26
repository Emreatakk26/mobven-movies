package com.example.movie ;

import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication ;
import org.springframework.boot.builder.SpringApplicationBuilder ;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer ;
import org.springframework.cache.annotation.EnableCaching ;

@SpringBootApplication
@EnableCaching
public class MovieApplication extends SpringBootServletInitializer
{

    public static void main( String[ ] args )
    {
        SpringApplication.run( MovieApplication.class, args ) ;
    }

    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application )
    {
        return application.sources( MovieApplication.class ) ;
    }
}
