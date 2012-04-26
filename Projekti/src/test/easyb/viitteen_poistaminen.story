import projekti.*
import projekti.kayttoliittyma.KomentoriviKayttoliittyma
import projekti.io.StubIO
import projekti.tiedostonkasittely.StubTK
import projekti.bibtex.StubBib
import projekti.toiminnot.*

description """Kayttaja pystyy poistamaan viitteen"""


scenario "kayttaja pystyy poistamaan olemassaolevia viitteita", {
    
    given 'kayttaja on valinnut komennon poista', {
        io = new StubIO("poista", "testilabel")

        tk = new StubTK()
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTietoa("title", "Otsikko4");
        tk.tallenna(uusi);

        bib = new StubBib()
        kayttoliittyma = new KomentoriviKayttoliittyma(io, tk, bib)
    }

    when 'haluttu viite on olemassa', {
        kayttoliittyma.kaynnista()
    }

    then 'viite poistetaan', {
        io.getOutput().shouldHave("Viite poistettiin")
    }
}

scenario "kayttaja ei pystyy poistamaan viiteen, jos se ei ole olemassa", {
    
    given 'kayttaja on valinnut komennon poista', {
        io = new StubIO("poista", "vaaralabel", "testilabel")

        tk = new StubTK()
        Viite uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTietoa("title", "Otsikko4");
        tk.tallenna(uusi);

        bib = new StubBib()
        kayttoliittyma = new KomentoriviKayttoliittyma(io, tk, bib)
    }

    when 'haluttu viite ei ole olemassa', {
        kayttoliittyma.kaynnista()
    }

    then 'jarjestelma ilmoittaa virheesta', {
        io.getOutput().shouldHave("Viite ei ole olemassa! Anna toinen label:")
    }
}

scenario "kayttaja ei pystyy poistamaan viiteen, jos tiedosto ei ole olemassa", {
    
    given 'kayttaja on valinnut komennon poista', {
        io = new StubIO("poista", "testilabel")

        tk = new StubTK();
        tk.poistaTiedosto();

        bib = new StubBib()
        kayttoliittyma = new KomentoriviKayttoliittyma(io, tk, bib)
    }

    when 'tiedosto ei ole olemassa', {
        kayttoliittyma.kaynnista()
    }

    then 'jarjestelma ilmoittaa virheesta', {
        io.getOutput().shouldHave("Viitteita ei ole tai tiedostoa ei ole olemassa.\n")
    }
}