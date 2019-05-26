package com.example.movie.scheduled ;

import org.json.JSONException ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.cache.CacheManager ;
import org.springframework.context.annotation.Configuration ;
import org.springframework.scheduling.annotation.EnableScheduling ;
import org.springframework.scheduling.annotation.Scheduled ;

@Configuration
@EnableScheduling
public class TaskSchedulerImpl implements TaskScheduler
{

    @Autowired
    CacheManager cacheManager ;

    @Scheduled( fixedDelay = 10 * 60 * 1000 )
    public void movieCacheClear( ) throws JSONException, Exception
    {
        evictAllCaches( ) ;
    }

    public void evictAllCaches( )
    {
        cacheManager.getCacheNames( ).stream( ).forEach( cacheName -> cacheManager.getCache( cacheName ).clear( ) ) ;
    }
}
