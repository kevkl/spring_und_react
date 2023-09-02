package Wertpapier;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Wertpapierservice {
		String baseUrl;

		public Wertpapierservice(String baseUrl) {
				this.baseUrl = baseUrl;
		}

		public List<String> getWertpapierkennzahlen() throws IOException {

				Reading rd = new Reading();
				HashMap<String, String> reits = rd.readingCsv("/reits.csv");
				HashMap<String, String> aktien = rd.readingCsv("/aktien.csv");
				HashMap<String, String> crypto = rd.readingCsv("/crypto.csv");
				return new GenerateReturnStatement().generate_return(reits, aktien, crypto);
		}

}
