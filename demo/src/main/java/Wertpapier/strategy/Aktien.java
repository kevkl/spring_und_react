package Wertpapier.strategy;

import Wertpapier.Wertpapier;
import Wertpapier.Wertpapierparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aktien implements Assets {

		private HashMap<String, String> aktien;

		public Aktien(HashMap<String, String> aktien) {
				this.aktien = aktien;
		}

		public Aktien() {

		}

		public ArrayList<String> getDatatoList() throws IOException {
				ArrayList<String> data = new ArrayList<>();

				for(Map.Entry<String, String> entry : aktien.entrySet()) {

						Wertpapierparser parser = new Wertpapierparser(entry.getValue());
						Aktien a = new Aktien();
						Wertpapier wertpapier = parser.parseDataAktienAndReits(entry.getKey(), new Aktien());

						data.addAll(List.of(wertpapier.toList()));
				}
				return data;
		}

		public String[] substring(String data, int index, int index_rsi){
				String [] result = new String[2];
				result[0] = data.substring(index, index + 6);
				result[1] = data.substring(index_rsi, index_rsi + 4);
				return result;
		}

}
