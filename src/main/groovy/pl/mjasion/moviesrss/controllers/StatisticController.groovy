package pl.mjasion.moviesrss.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.mjasion.moviesrss.domain.repository.BluerayPremiereRepository
import pl.mjasion.moviesrss.domain.repository.GenreRepository
import pl.mjasion.moviesrss.domain.repository.MovieRepository

@RestController
@RequestMapping('/statistics')
class StatisticController {

    @Autowired BluerayPremiereRepository bluerayPremiereRepository
    @Autowired GenreRepository genreRepository
    @Autowired MovieRepository movieRepository

    @RequestMapping
    Map statistics() {
        return [
                genres   : genreRepository.count(),
                movies   : movieRepository.count(),
                premieres: bluerayPremiereRepository.count(),
        ]
    }
}