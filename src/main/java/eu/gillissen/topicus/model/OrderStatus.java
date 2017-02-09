package eu.gillissen.topicus.model;

import javax.persistence.Embeddable;

@Embeddable
public enum OrderStatus {
    BEING_PROCESSED,
    ACCEPTED,
    PAYMENT_RECEIVED,
    PAYMENT_SENT,
    CANCELED,
    FINISHED;

    @Override
    public String toString() {
        switch (this) {
            case BEING_PROCESSED:
                return "in behandeling";
            case ACCEPTED:
                return "akkoord";
            case PAYMENT_RECEIVED:
                return "betaling ontvangen";
            case PAYMENT_SENT:
                return "betaling verstuurd";
            case CANCELED:
                return "geannuleerd";
            case FINISHED:
                return "afgehandeld";
            default:
                return "onbekende status";
        }
    }
}
