

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse TestShoppingBasket.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TestShoppingBasket
{ 
    /**
     * Konstruktor fuer die Test-Klasse TestShoppingBasket
     */
    public TestShoppingBasket()
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
    public void printTest()
    {
        System.out.println("Baustrahler muss 3x vorkommen, iPhone muss 2x vorkommen, Schuessel darf nicht existieren");
        Catalog catalog1 = new Catalog();
        catalog1.addProduct("Baustrahler", 12);
        catalog1.addProduct("iPhone", 99999);
        catalog1.addProduct("Schuessel", 8);
        catalog1.addProduct("Produkt m. neg. Preis", 8);
        catalog1.addProduct("super langer Produktname der nicht in eine Zeile passt", 1);
        catalog1.addProduct("Buch", 31134);
        catalog1.addProduct("B", 25612);
        catalog1.addProduct("Stuhl", 2412);
        catalog1.addProduct("TShirt", 2812);
        catalog1.addProduct("Lampe", 7212);
        ShoppingBasket shoppingbask1 = new ShoppingBasket(catalog1);
        
        shoppingbask1.addItem("Schuessel");
        
        shoppingbask1.print();
        
        
    }
    
    @Test
    public void printPackList()
    {
        Catalog catalog1 = new Catalog();
        
        catalog1.addProduct("Baustrahler", 212);
        catalog1.addProduct("iPhone", 650);
        catalog1.addProduct("Schuessel", 3188);
        catalog1.addProduct("Produkt m. neg. Preis", 3188);
        catalog1.addProduct("super langer Produktname der nicht in eine Zeile passt", 1100);
        catalog1.addProduct("Buch", 31134);
        catalog1.addProduct("B", 25612);
        catalog1.addProduct("Stuhl", 2412);
        catalog1.addProduct("TShirt", 2812);
        catalog1.addProduct("Lampe", 7212);
        catalog1.addProduct("I", 7212);
        ShoppingBasket shoppingbask1 = new ShoppingBasket(catalog1);
        shoppingbask1.addItem("Baustrahler");
        
        shoppingbask1.addItem("Baustrahler");
        shoppingbask1.addItem("iPhone");
        shoppingbask1.addItem("I");
        shoppingbask1.addItem("Schuessel");
        shoppingbask1.addItem("Produkt m. neg. Preis");
        shoppingbask1.addItem("super langer Produktname der nicht in eine Zeile passt");
        shoppingbask1.addItem("Buch");
        shoppingbask1.addItem("B");
        shoppingbask1.addItem("TShirt");
        shoppingbask1.addItem("Lampe");
        shoppingbask1.addItem("iPhone");
        shoppingbask1.addItem("Baustrahler");
        shoppingbask1.addItem("Stuhl");
        System.out.println("nochmal in Sortiert: ");
        shoppingbask1.sortByName();
        
        shoppingbask1.print();
        
        shoppingbask1.printPackList();
    }
}

