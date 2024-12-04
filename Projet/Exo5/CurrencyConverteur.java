package Exo5;

public class CurrencyConverteur {
    public static Double convertToUSD (String currency, Double amount) {
        if (currency.equals("EUR")) {
            return amount * 1.1;
        }
        if (currency.equals("GBP")) {
            return amount * 1.3;
        }
        return amount;
    }

    public static Double convertFromUSD (String currency, Double amount) {
        if (currency.equals("EUR")) {
            return amount / 1.1;
        }
        if (currency.equals("GBP")) {
            return amount / 1.3;
        }
        return amount;
    }
}
