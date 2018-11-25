

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse TestCatalog.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TestCatalog
{
    /**
     * Konstruktor fuer die Test-Klasse TestCatalog
     */
    public TestCatalog()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void addItemTest()
    {
        Catalog catalog1 = new Catalog();
        catalog1.addProduct("Baustrahler", 212);
        catalog1.addProduct("iPhone", 650);
        catalog1.addProduct("Schuessel", 3188);
        catalog1.addProduct("Produkt m. neg. Preis", -3188);
        catalog1.addProduct("doppeltes Produkt", 1100);
        catalog1.addProduct("doppeltes Produkt", 1100);
        System.out.println("---------------------------------");
    }
    
    @Test
    public void showProductTest()
    {
        Catalog catalog1 = new Catalog();
        catalog1.addProduct("Baustrahler", 212);
        catalog1.addProduct("iPhone", 650);
        catalog1.showProduct("iPhone");
        catalog1.showProduct("Baustrahler");
        System.out.println("---------------------------------");
    }
}


