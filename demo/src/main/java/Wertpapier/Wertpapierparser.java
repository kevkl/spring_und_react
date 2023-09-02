package Wertpapier;

import Wertpapier.strategy.Assets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Wertpapierparser {

		private final Document DOC;

		public Wertpapierparser(String blogUrl) throws IOException {
				DOC = Jsoup.connect(blogUrl).get();
		}
		public Wertpapier parseDataCrypto(String name) {

				String[] metrics = new Scraping(DOC).scrapCrypto();

				String[] buildData = new Substring().check_Cryptocurrency(name, metrics[0], metrics[1]);

				DataCheckup dataCheckup = new DataCheckup();
				String kaufen = dataCheckup.checkBuyingCrypto(dataCheckup.convertStringToDouble(buildData[0]), dataCheckup.convertStringToDouble(buildData[1]));

				String avgDiffrence = dataCheckup.avgDiffrence(dataCheckup.convertStringToDouble(buildData[0]),dataCheckup.convertStringToDouble(buildData[1]));

				return new Wertpapier(name, buildData[0], buildData[1], kaufen, avgDiffrence);
		}

		public Wertpapier parseDataAktienAndReits(String name, Assets wertpapiere) {

				String[] scrapeData = new Scraping(DOC).scrapAktien();
				String fullTextForAveragePrice = scrapeData[0];
				String fullTExtForNewPrice = scrapeData[1];
				int [] extractAveragePriceAndRsi = new Substring().indexingData(fullTextForAveragePrice);

				String[] result = new Substring().substringAssets(wertpapiere, fullTextForAveragePrice, extractAveragePriceAndRsi[0], extractAveragePriceAndRsi[1], fullTExtForNewPrice);

				DataCheckup dataCheckup = new DataCheckup();
				String kaufen = dataCheckup.checkBuying(dataCheckup.convertStringToDouble(result[0]), dataCheckup.convertStringToDouble(result[2]), dataCheckup.convertStringToDouble(result[1]));
				String avgDiffrence = dataCheckup.avgDiffrence(dataCheckup.convertStringToDouble(result[0]),dataCheckup.convertStringToDouble(result[2]));

				return new Wertpapier(name, result[0], result[1], result[2], kaufen, avgDiffrence);
		}

}
