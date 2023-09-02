package Wertpapier;

public class Wertpapier {
		private String name, average, rsi, actualPrice, kaufen, avgDiffrence;

		public Wertpapier(String name, String average, String rsi, String actualPrice, String kaufen , String avgDiffrence) {
				this.name = name;
				this.average = average;
				this.rsi = rsi;
				this.actualPrice = actualPrice;
				this.kaufen = kaufen;
				this.avgDiffrence=avgDiffrence;
		}

		public Wertpapier(String name, String average, String actualPrice, String kaufen, String avgDiffrence) {
				this.name = name;
				this.average = average;
				this.actualPrice = actualPrice;
				this.kaufen = kaufen;
				this.avgDiffrence=avgDiffrence;
		}

		public String[] toList() {
				return new String[]{name, average, rsi, actualPrice, kaufen, avgDiffrence};
		}

		public String[] toListCrypto() {
				return new String[]{name, average, actualPrice, kaufen,avgDiffrence};
		}
}
