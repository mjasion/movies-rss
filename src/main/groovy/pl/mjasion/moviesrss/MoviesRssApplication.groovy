package pl.mjasion.moviesrss

import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@CompileStatic
@EnableScheduling
class MoviesRssApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MoviesRssApplication.class, args)
    }

}