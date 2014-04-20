package pl.mjasion.filmwebrss.service

import org.jsoup.nodes.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import pl.mjasion.filmwebrss.IntegrationSpec

class FilmwebServiceIntegrationSpec extends IntegrationSpec {
    @Autowired FilmwebService filmwebService

    @Value('${filmweb.url}')
    String filmwebUrl

    def "should get filmweb page"() {
        when:
        Document page = filmwebService.getPage('https://google.com/')

        then:
        page != null
        page.body() != null
    }

    def "should get dvd premieres list"() {
        when:
        DvdPremieresDto premieres = filmwebService.getDvdPremiersDto()

        then:
        premieres.premieres.size() > 0
        premieres.nextPageLink != null
        premieres.nextPageLink.startsWith(filmwebUrl)
        premieres.previousPageLink != null
        premieres.previousPageLink.startsWith(filmwebUrl)
    }
}
