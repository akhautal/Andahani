import projekti.*
import projekti.kayttoliittyma.KomentoriviKayttoliittyma
import projekti.io.StubIO
import projekti.tiedostonkasittely.StubTK
import projekti.bibtex.StubBib
import projekti.toiminnot.*

description """Kayttaja pystyy kirjoittamaan vaaria komentoja"""


scenario "kayttaja pystyy kirjoittamaan vaaria komentoja, ilman etta tulee virhe", {
    
    given 'kayttaja on valinnut tuntematon komento', {
        io = new StubIO("asdfghjkl")
        tk = new StubTK();
        bib = new StubBib()
        kayttoliittyma = new KomentoriviKayttoliittyma(io, tk, bib)
    }

    when 'komento ei ole tuettujen komentojen listassa', {
        kayttoliittyma.kaynnista()
    }

    then 'jarjestelma tulostaa oikeat komennot kayttajalle', {
        io.getOutput().shouldHave("Sallitut komennot: lisaa, listaa, bib, tagi, haku ja lopeta.")
    }
}