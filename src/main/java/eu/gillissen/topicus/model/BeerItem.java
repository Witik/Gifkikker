package eu.gillissen.topicus.model;

import javax.persistence.Entity;

/**
 * An item which contains beer.
 */
@Entity
public class BeerItem extends StockItem {
    /**
     * Volume in centiliters.
     */
    private int volume;
    /**
     * Percentage of alcohol.
     */
    private double alcoholPercentage;
    /**
     * Type of beer, e.g.: Grolsch, Heineken, Gifkikker.
     */
    private String beerType;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }
}
