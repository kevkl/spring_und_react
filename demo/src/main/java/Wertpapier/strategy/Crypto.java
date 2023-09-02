package Wertpapier.strategy;

import Wertpapier.Wertpapier;
import Wertpapier.Wertpapierparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crypto implements Assets {

		private HashMap<String, String> crypto;

		public Crypto(HashMap<String, String> crypto) {

				this.crypto = crypto;
		}

		public ArrayList<String> getDatatoList() throws IOException {
				ArrayList<String> data = new ArrayList<>();

				for(Map.Entry<String, String> entry : crypto.entrySet()) {

						Wertpapierparser parser = new Wertpapierparser(entry.getValue());

						Wertpapier wertpapier = parser.parseDataCrypto(entry.getKey());

						data.addAll(List.of(wertpapier.toListCrypto()));
				}
				return data;
		}

		@Override
		public String[] substring(String data, int index, int index_rsi) {
				return new String[0];
		}

}
