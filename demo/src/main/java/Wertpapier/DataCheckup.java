package Wertpapier;

public class DataCheckup {

		private final double CRYPTO_PERCENTAGE_UNDER_AVERAGE = 1;
		private final double AKTIEN_PERCENTAGE_UNDER_AVERAGE = 1;

		public double convertStringToDouble(String price) {

				return Double.parseDouble(price.replace(",", "."));
		}
		public String avgDiffrence(double averagePrice, double actualPrice){

					return averagePrice>actualPrice ? "-"+(int) ((averagePrice-actualPrice)/averagePrice*100)+" %": "+"+(int) ((actualPrice-averagePrice)/actualPrice*100)+" %";

		}
		public String checkBuyingCrypto(double averagePrice, double actualPrice) {

				return (actualPrice <= averagePrice * CRYPTO_PERCENTAGE_UNDER_AVERAGE) ? "Ja" : "Nein";
		}

		public String checkBuying(double averagePrice, double actualPrice, double rsi) {

				return (actualPrice <= averagePrice * AKTIEN_PERCENTAGE_UNDER_AVERAGE & rsi < 1) ? "Ja" : "Nein";
		}

}
