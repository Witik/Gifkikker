package eu.gillissen.topicus.model;

import javax.persistence.Entity;

@Entity
public class BeerItem extends StockItem {
    private int volume;
    private double alcoholPercentage;
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
