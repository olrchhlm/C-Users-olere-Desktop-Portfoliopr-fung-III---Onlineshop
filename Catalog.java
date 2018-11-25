import java.util.HashMap;

/**
 * Handles a catalog with Products and their prices.
 *
 * @author Reichhelm, Witt
 * @version 2018-09-04
 */
public class Catalog {
    private HashMap<String, Integer> productCatalog;

    public Catalog() {
        productCatalog = new HashMap<>();
    }

    //Annahme: Wir gehen davon aus, dass in einem Katalog keine Produkte mit negativen Preisen eingegeben werden.
    public void addProduct(String productName, int productPrice) {
        if (hasProduct(productName)) {
            System.out.println(productName + " already exists");
        } else {
            productCatalog.put(productName, productPrice);
        }
    }

    public void updateProduct(String productName, int productPrice) {
        if (hasProduct(productName)) {
            productCatalog.put(productName, productPrice);
        } else {
            productNotFound(productName);
        }
    }

    public void deleteProduct(String productName) {
        if (hasProduct(productName)) {
            productCatalog.remove(productName);
        } else {
            productNotFound(productName);
        }
    }

    public void showProduct(String productName) {
        if (hasProduct(productName)) {
            System.out.println(productName + " Preis: " + convertCentToEuro(productCatalog.get(productName)) + "€");
        } else {
            productNotFound(productName);
        }
    }

    private void productNotFound(String productName) {
        System.out.println(productName + " does not exist");
    }

    public int getProductPrice(String productName) {
        return hasProduct(productName) ? productCatalog.get(productName) : -1;
    }

    //Annahme: Diese Funktion ist in den Aufgaben nicht weiter beschrieben. Wir haben die Annahme getroffen, dass diese Funtion einen Wahrheitswert zurückgibt, ob das gesuchte Produkt im Catalog vorhanden ist. 
    public boolean hasProduct(String productName) {
        return productCatalog.containsKey(productName);
    }

    private String convertCentToEuro(int value) {
        String euros = Integer.toString(value / 100);
        int cents = value % 100;
        if (cents < 10) {
            euros += ",0";
        } else {
            euros += ",";
        }
        euros += Integer.toString(cents);
        return euros;
    }
}
