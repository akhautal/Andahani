import projekti.*
import projekti.kayttoliittyma.KomentoriviKayttoliittyma
import projekti.io.StubIO
import projekti.tiedostonkasittely.StubTK
import projekti.bibtex.StubBib
import projekti.toiminnot.*

description """Kayttaja pystyy listaamaan kaikki viitteet"""


scenario "kayttaja pystyy listamaan epatyhjan viitteiden listan", {
    given 'kayttaja on valinnut komennon lista', {
        io = new StubIO("lisaa", "2", "label1", "abc", "cdf", "","","","","","","", "", "", 
                        "lisaa","1", "label2", "author", "kirja", "","","","","","","", "", "", 
                        "lista")
        tk = new StubTK()
        bib = new StubBib()
        kayttoliittyma = new KomentoriviKayttoliittyma(io, tk, bib)
    }

    when 'viitteiden lista on epatyhja', {
        kayttoliittyma.kaynnista()
    }

    then 'lista on tulostettu', {
        io.getOutput().shouldHave("millainenViite = @book")
        io.getOutput().shouldHave("label = label1")
        io.getOutput().shouldHave("author = abc")
        io.getOutput().shouldHave("title = cdf")

        io.getOutput().shouldHave("millainenViite = @inproceedings")
        io.getOutput().shouldHave("label = label2")
        io.getOutput().shouldHave("author = author")
        io.getOutput().shouldHave("title = kirja")
    }
}

scenario "kayttaja pystyy listamaan tyhjan viitteiden listan", {
    given 'kayttaja on valinnut komennon lista', {
        io = new StubIO("lista")
        tk = new StubTK()
        bib = new StubBib()
        kayttoliittyma = new KomentoriviKayttoliittyma(io, tk, bib)
    }

    when 'viitteiden lista on tyhja', {
        kayttoliittyma.kaynnista()
    }

    then 'Jarjestelma kertoo, etta viiteita ei ole', {
        io.getOutput().shouldHave("Viitteita ei ole tai tiedosto ei ole olemassa.\n")
    }
}

scenario "kayttaja pystyy listamaan viitteiden listan, jos viitteilla on tageja", {
    given 'kayttaja on valinnut komennon lista', {
        io = new StubIO("lisaa", "2", "label1", "abc", "cdf", "","","","","","","","","tagi1", "tagi2", "",
                        "lisaa","1", "label2", "author", "kirja", "","","","","","","","","jokutagi","",
                        "lista")
        tk = new StubTK()
        bib = new StubBib()
        kayttoliittyma = new KomentoriviKayttoliittyma(io, tk, bib)
    }

    when 'viitteiden lista on epatyhja ja viitteilla on tageja', {
        kayttoliittyma.kaynnista()
    }

    then 'Jarjestelma kertoo, etta viiteita ei ole', {
        io.getOutput().shouldHave("tagit: tagi1,tagi2.")
        io.getOutput().shouldHave("tagit: jokutagi.")
    }
}