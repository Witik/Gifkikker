package eu.gillissen.topicus.model;

import javax.persistence.Embeddable;

@Embeddable
public class Euro {
    private int cents;
    private int euros;

    public Euro() {
    }

    public Euro(int euros, int cents) {
        setEuros(euros);
        setCents(cents);
    }

    public Euro plus(int euros, int cents) {
        return new Euro(this.euros + euros,this.cents + cents);
    }

    public Euro plus(Euro money) {
        return new Euro(this.euros + money.getEuros(),this.cents + money.getCents());
    }

    public Euro times(int factor) {
        return new Euro(this.euros * factor, this.cents * factor);
    }


    public int getEuros() {
        return euros;
    }

    public void setEuros(int euros) {
        this.euros = euros;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents += cents % 100;
        this.euros += Math.floorDiv(cents, 100);
    }

    @Override
    public String toString() {
        return String.format("%d,%02d", euros, cents);
    }
}
