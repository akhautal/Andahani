import projekti.*
import projekti.kayttoliittyma.KomentoriviKayttoliittyma
import projekti.io.StubIO
import projekti.tiedostonkasittely.StubTK
import projekti.bibtex.StubBib
import projekti.toiminnot.*

description """Kayttaja voi hakea viitteita tagien perusteella"""

scenario "Kayttaja voi hakea viitteita tagin perustella, jos annettu tagi on olemassa", {

    given 'kayttaja on valinnut komennon haku' , {
        io = new StubIO("haku", "tagi")

        
        tk = new StubTK();
        uusi = new Viite();
        uusi.lisaaTietoa("millainenViite", "@book");
        uusi.lisaaTietoa("label", "testilabel");
        uusi.lisaaTietoa("author", "Pekka2");
        uusi.lisaaTietoa("title", "Otsikko4");
        uusi.lisaaTagi("tagi");
        tk.tallenna(uusi);
 \
        bib = new StubBib()
        kayttoliittyma = new KomentoriviKayttoliittyma(io, tk, bib)
    }

    when 'haettu tagi on olemassa' , {
        kayttoliittyma.kaynnista()
    }

    then 'jarjestelma listaa viitteita', {
        io.getOutput().shouldHave("tagit: tagi.")
    }
}

