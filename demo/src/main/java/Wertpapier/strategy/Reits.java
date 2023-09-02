package Wertpapier.strategy;

import Wertpapier.Wertpapier;
import Wertpapier.Wertpapierparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reits implements Assets {

		private HashMap<String, String> reits;

		public Reits(HashMap<String, String> reits) {
				this.reits = reits;
		}

		public Reits() {

		}

		public ArrayList<String> getDatatoList() throws IOException {
				ArrayList<String> data = new ArrayList<>();

				for(Map.Entry<String, String> entry : reits.entrySet()) {
						Wertpapierparser parser = new Wertpapierparser(entry.getValue());
						Reits reits = new Reits();
						Wertpapier wertpapier = parser.parseDataAktienAndReits(entry.getKey(), new Reits());

						data.addAll(List.of(wertpapier.toList()));
				}
				return data;
		}
		public String[] substring(String data, int indexAveragePrice,int indexRsi){
				String [] result = new String[2];
				result[0] = data.substring(indexAveragePrice, indexAveragePrice + 6);
				result[1] = data.substring(indexRsi, indexRsi + 4);
				return result;
		}
}
