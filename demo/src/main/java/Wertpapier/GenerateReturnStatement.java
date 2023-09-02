package Wertpapier;

import Wertpapier.strategy.Aktien;
import Wertpapier.strategy.Crypto;
import Wertpapier.strategy.Reits;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GenerateReturnStatement {
		private final ArrayList<String> ALL_DATA = new ArrayList<>();

		public ArrayList<String> generate_return(HashMap<String, String> reits, HashMap<String, String> aktien, HashMap<String, String> crypto) throws IOException {

				ALL_DATA.add("" + reits.size());
				ALL_DATA.add("" + aktien.size());
				ALL_DATA.add("" + crypto.size());

				ALL_DATA.addAll(new Reits(reits).getDatatoList());
				ALL_DATA.addAll(new Aktien(aktien).getDatatoList());
				ALL_DATA.addAll(new Crypto(crypto).getDatatoList());

				return ALL_DATA;

		}
}
