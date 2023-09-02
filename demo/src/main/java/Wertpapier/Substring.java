package Wertpapier;

import Wertpapier.strategy.Assets;

public class Substring {
		public int[] indexingData(String data) {

				return new int[]{data.indexOf("Durchschn. - 200T") + 18, data.indexOf("RSL - 30T") + 10};
		}

		public String[] check_Cryptocurrency(String name, String data, String actualPrice) {
				switch(name) {
						case ("Bitcoin") -> {
								data = data.substring(14, 20);
								actualPrice = actualPrice.substring(0, 6);
						}
						case ("Ethereum") -> {
								data = data.substring(13, 18);
								actualPrice = actualPrice.substring(0, 5);
						}
						case ("Litecoin") -> {
								data = data.substring(10, 15);
								actualPrice = actualPrice.substring(0, 5);
						}
						case ("Ripple") -> {
								data = data.substring(10, 15);
								actualPrice = actualPrice.substring(0, 4);
						}
				}
				return new String[]{data, actualPrice};

		}

		public String[] substringAssets(Assets asset, String data, int indexAvergaePrice, int indexRsi, String actualPrice) {

				String[] erg = asset.substring(data, indexAvergaePrice, indexRsi);

				return new String[]{erg[0], erg[1], actualPrice.substring(0, 7)};

		}
}


