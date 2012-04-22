import projekti.*
import projekti.kayttoliittyma.KomentoriviKayttoliittyma
import projekti.io.StubIO
import projekti.tiedostonkasittely.StubTK
import projekti.bibtex.StubBib
import projekti.toiminnot.*

description """Kayttaja pystyy lisaamaan tageja viitteisiin"""


scenario "kayttaja pystyy lisaamaan tageja olemassaoleviin viitteisiin", {
    
    given 'kayttaja on valinnut komennon tagi', {
        io = new StubIO("tagi", "testilabel", "ekatagi", "tokatagi", "")

        tk = new StubTK();
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

    then 'tagi on lisatty viitteeseen', {
        io.getOutput().shouldHave("Tagit lisatty.\n")
    }
}