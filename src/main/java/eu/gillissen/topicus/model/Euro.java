package eu.gillissen.topicus.model;

import javax.persistence.Embeddable;

/**
 * Currency object.
 */
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

    /**
     * Adds the current amount to the given amount, returns a new instance of Euro with the new total.
     *
     * @param euros The amount of euros to add.
     * @param cents The amount of cents to add.
     * @return a new instance of Euro with the new total.
     */
    public Euro plus(int euros, int cents) {
        return new Euro(this.euros + euros, this.cents + cents);
    }

    /**
     * Adds the current amount to the amount in the given Euro object. Returns a new instance of Euro with the new total.
     *
     * @param money The euro object with the amount to add.
     * @return a new instance of Euro with the new total.
     */
    public Euro plus(Euro money) {
        return new Euro(this.euros + money.getEuros(), this.cents + money.getCents());
    }

    /**
     * Multiplies the current amount with the given factor. Returns a new instance of Euro with the new total.
     *
     * @param factor The factor to multiply with.
     * @return a new instance of Euro with the new total.
     */
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
