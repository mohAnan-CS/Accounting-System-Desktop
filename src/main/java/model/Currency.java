package model;

public class Currency {

   String currencyType;
   double currencyValue;

   public Currency(String currencyType, double currencyValue) {
      this.currencyType = currencyType;

      this.currencyValue = currencyValue;
   }

   @Override
   public String toString() {
      return "Currency{" +
              "currencyType='" + currencyType + '\'' +
              ", currencyValue=" + currencyValue +
              '}';
   }

   public String getCurrencyType() {
      return currencyType;
   }

   public void setCurrencyType(String currencyType) {
      this.currencyType = currencyType;
   }

   public double getCurrencyValue() {
      return currencyValue;
   }

   public void setCurrencyValue(double currencyValue) {
      this.currencyValue = currencyValue;
   }
}
