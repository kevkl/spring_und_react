package Wertpapier.strategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface Assets {
		HashMap<String, String> map = null;
		public ArrayList<String> getDatatoList() throws IOException;
		public String[] substring(String data, int index,int index_rsi);

}
