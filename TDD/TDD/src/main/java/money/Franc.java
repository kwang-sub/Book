package money;

import java.util.Objects;

public class Franc extends Money {

    public Franc(int amount) {
        this.amount = amount;
    }

    @Override
    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

}
