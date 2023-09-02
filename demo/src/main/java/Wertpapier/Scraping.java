package Wertpapier;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Scraping {
		private final Document DOC;
		public Scraping(Document doc) {
				this.DOC = doc;
		}
		public String[] scrapAktien() {
				Elements fullHtmlText = DOC.getElementsByClass("ov-carousel ov-carousel--table-fixed-cells ov-snapshot-technical-0 outer-spacing--large-top");

				Elements fullTextForPrice = DOC.getElementsByClass("outer-spacing--xsmall-top text-size--xxlarge text-size--xlarge-sm text-weight--bold");

				return new String[]{fullHtmlText.first().text(), fullTextForPrice.first().text()};

		}
		public String[] scrapCrypto() {
				Elements fullHtmlText = DOC.getElementsByClass("text-size--large text-weight--medium");
				Elements fullHtmlPriceText = DOC.getElementsByClass("outer-spacing--xsmall-top text-size--xxlarge text-size--xlarge-sm text-weight--bold");

				return new String[]{fullHtmlText.text(), fullHtmlPriceText.text()};
		}
}
