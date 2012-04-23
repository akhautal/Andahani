import projekti.*
import projekti.kayttoliittyma.KomentoriviKayttoliittyma
import projekti.io.StubIO
import projekti.tiedostonkasittely.StubTK
import projekti.bibtex.StubBib
import projekti.toiminnot.*

description """Kayttaja pystyy luomaan viitteista bib-tiedosto"""


scenario "kayttaja pystyy luomaan uusi bibtext tiedosto, jos han antaa kelvollinen tiedoston nimi", {
    
    given 'kayttaja on valinnut komennon lista', {
        io = new StubIO("bib", "nimi.bib")

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

    when 'viitteiden lista on epatyhja', {
        kayttoliittyma.kaynnista()
    }

    then 'lista on tulostettu', {
        io.getOutput().shouldHave("Viitteet tallennettu tiedostoon nimi.bib")
    }
}

scenario "kayttaja ei pysty luomaan uutta bibtext tiedostoa, jos tiedoston nimen paate ei ole .bib", {
    given 'kayttaja on valinnut komennon lista', {
        io = new StubIO("bib", "nimi.bi", "nimi.bib")

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

    when 'tiedoston nimen lopussa ei ole .bib', {
        kayttoliittyma.kaynnista()
    }

    then 'tiedostoa ei ole luotu vaaralla nimella', {
        io.getOutput().shouldHave("Anna toinen nimi.")
        io.getOutput().shouldHave("Viitteet tallennettu tiedostoon nimi.bib")
    }
}

scenario "kayttaja ei pysty luomaan uutta bibtext tiedostoa, jos annetun tiedoston nimen alussa on piste", {
    given 'kayttaja on valinnut komennon lista', {
        io = new StubIO("bib", ".nimi.bib", "nimi.bib")

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

    when 'tiedoston nimen alussa on piste', {
        kayttoliittyma.kaynnista()
    }

    then 'tiedostoa ei ole luotu vaaralla nimella', {
        io.getOutput().shouldHave("Anna toinen nimi.")
        io.getOutput().shouldHave("Viitteet tallennettu tiedostoon nimi.bib")
    }
}

scenario "kayttaja ei pysty luomaan uutta bibtext tiedostoa, jos annetussa tiedoston nimessa on erikoinen merkki", {
    given 'kayttaja on valinnut komennon lista', {
        io = new StubIO("bib", "nimi*.bib", "nimi.bib")

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

    when 'tiedoston nimessa on joku erikoinen merkki', {
        kayttoliittyma.kaynnista()
    }

    then 'tiedostoa ei ole luotu vaaralla nimella', {
        io.getOutput().shouldHave("Anna toinen nimi.")
        io.getOutput().shouldHave("Viitteet tallennettu tiedostoon nimi.bib")
    }
}

scenario "kayttaja ei pysty luomaan uutta bibtext tiedostoa, jos han antaa tyhja tiedoston nimi", {
    given 'kayttaja on valinnut komennon lista', {
        io = new StubIO("bib", "", "nimi.bib")

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

    when 'tiedoston nimessa on joku erikoinen merkki', {
        kayttoliittyma.kaynnista()
    }

    then 'tiedostoa ei ole luotu vaaralla nimella', {
        io.getOutput().shouldHave("Anna toinen nimi.")
        io.getOutput().shouldHave("Viitteet tallennettu tiedostoon nimi.bib")
    }
}