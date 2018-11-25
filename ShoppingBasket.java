import java.util.ArrayList;
import java.util.Collections; 
import java.util.HashSet;

/**
 * Handles a shoppingbasket for products from a catalogue.
 *
 * @author Reichhelm, Witt
 * @version 2018-0904
 */
public class ShoppingBasket {
    private Catalog products;
    private ArrayList<String> productsInBasket;
    //Für bessere Wartbarkeit
    private String tableSeparator = "|";

    public ShoppingBasket(Catalog catalog) {
        products = catalog;
        productsInBasket = new ArrayList<>();
    }

    public void addItem(String itemName) {
        if (products.hasProduct(itemName)) {
            productsInBasket.add(itemName);
        } else {
            productNotFound(itemName);
        }
    }

    public void deleteItem(int position) {
        if (productsInBasket.size() > position) {
            productsInBasket.remove(position);
        } else {
            productNotFound("Position: " + position);
        }
    }

    public void deleteItems(String itemName) {
        if(!productsInBasket.removeAll(Collections.singleton(itemName))){
            productNotFound(itemName);
        }
    }

    public void print() {
        int basketTotalValue = 0;
        String printSpacer = "+-----------------------------------+-------+";
        String printHeader = tableSeparator + "Pos" + tableSeparator + "Produkt"
            + createWhiteSpace(24) + tableSeparator
            + "Preis" + createWhiteSpace(2) + tableSeparator;
        System.out.println(printSpacer + "\n" + printHeader + "\n" + printSpacer);
        for (int i = 0; i < productsInBasket.size(); i++) {
            System.out.println(printProductLine(i));
            basketTotalValue += products.getProductPrice(productsInBasket.get(i));
        }
        System.out.println(printSpacer + "\n" + tableSeparator + createWhiteSpace(29) + "Summe:"
            + generateWhiteSpacesForSum(basketTotalValue / 100) + convertCentToEuro(basketTotalValue)
            + "€" + tableSeparator + "\n" + printSpacer);
    }

    private String printProductLine(int basketIndex) {
        int priceForProduct = products.getProductPrice(productsInBasket.get(basketIndex));
        return tableSeparator + generateWhiteSpaces(basketIndex + 1)
        + (basketIndex + 1) + tableSeparator
        + correctProductLength(productsInBasket.get(basketIndex)) + tableSeparator
        + generateWhiteSpaces(priceForProduct / 100)
        + convertCentToEuro(priceForProduct) + "€" + tableSeparator;
    }

    private String correctProductLength(String originalProductName) {
        String correctProductName = "";
        if (originalProductName.length() <= 31) {
            correctProductName = originalProductName + createWhiteSpace(31 - originalProductName.length());
        } else {
            correctProductName = originalProductName.substring(0, 31);
        }
        return correctProductName;
    }

    //Annahme: aus dem Methodennamen "sortByName" geht für uns nur die Sortierung hervor, nicht aber die Ausgabe. 
    public void sortByName() {
        Collections.sort(productsInBasket,String.CASE_INSENSITIVE_ORDER);
    }

    public void printPackList() {
        HashSet<String> packList = new HashSet<>(productsInBasket);
        for (String packListItem : packList) {
            System.out.println(packListItem + ": " + Collections.frequency(productsInBasket, packListItem));
        }
    }

    private void productNotFound(String productName) {
        System.out.println(productName + " does not exist");
    }

    private String generateWhiteSpaces(int inputInt) {
        if (inputInt < 10) {
            return createWhiteSpace(2);
        } else if (inputInt < 100) {
            return createWhiteSpace(1);
        }
        return "";
    }

    private String generateWhiteSpacesForSum(int inputInt) {
        if(inputInt < 10){
            return createWhiteSpace(3);
        }else if (inputInt < 100) {
            return createWhiteSpace(2);
        } else if (inputInt < 1000) {
            return createWhiteSpace(1);
        }
        return "";
    }

    private String createWhiteSpace(int size) {
        String whiteSpaceString = "";
        for (int i = 0; i < size; i++) {
            whiteSpaceString += " ";
        }
        return whiteSpaceString;
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
