import projekti.*
import projekti.kayttoliittyma.KomentoriviKayttoliittyma
import projekti.io.StubIO
import projekti.tiedostonkasittely.StubTK
import projekti.bibtex.StubBib
import projekti.toiminnot.*

description """Kayttaja pystyy lisaamaan uusi viite jarjestelmaan"""

scenario "kayttaja pystyy lisaamaan uusi viite, jos annetut tiedot on oikein", {

    given 'kayttaja on valinnut komennon lisaa' , {
        io = new StubIO("lisaa", "2", "label10", "abc", "cdf")
        tk = new StubTK()
        bib = new StubBib()
        kayttoliittyma = new KomentoriviKayttoliittyma(io, tk, bib);
    }

    when 'label on mielivaltainen merkkijono joka ei viela ole olemassa jarjestelmassa' , {
        kayttoliittyma.kaynnista()
    }

    then 'Uusi viite on lisatty', {
        io.getOutput().shouldHave("Uusi viite lisatty jarjestelmaan.")
    }
}

scenario "kayttaja ei pystyy lisaamaan uusi viite, jos annettu label on jo olemassa", {

    given 'kayttaja on valinnut komennon lisaa' , {
        io = new StubIO("lisaa", "2", "label10", "abc", "cdf", "","","","","","","", "", "", "lisaa","1", "label10", "oikealabel")
        tk = new StubTK()
        bib = new StubBib()
        kayttoliittyma = new KomentoriviKayttoliittyma(io, tk, bib);
    }

    when 'label on mielivaltainen merkkijono joka ei viela ole olemassa jarjestelmassa' , {
        kayttoliittyma.kaynnista()
    }

    then 'Uusi viite on lisatty', {
        io.getOutput().shouldHave("Tama label on jo kaytossa!")
    }
}

