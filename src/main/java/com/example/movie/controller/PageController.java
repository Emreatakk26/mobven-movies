package com.example.movie.controller ;

import org.springframework.stereotype.Controller ;
import org.springframework.ui.Model ;
import org.springframework.web.bind.annotation.GetMapping ;
import org.springframework.web.bind.annotation.RequestParam ;

@Controller
public class PageController
{
    @GetMapping( { "/h", "/hello" } )
    public String hello( Model model, @RequestParam( value = "name", required = false, defaultValue = "World" ) String name )
    {
        model.addAttribute( "name", name ) ;
        return "hello" ;
    }

    @GetMapping( { "/s", "/search" } )
    public String search( Model model, @RequestParam( value = "title", required = false, defaultValue = "World" ) String title )
    {
        model.addAttribute( "name", title ) ;
        return "search" ;
    }
}
