import java.math.BigDecimal;

public record CurrencyValue(BigDecimal conversion_rate) {

    public BigDecimal getConversionRate() {
        return conversion_rate;
    }
}


