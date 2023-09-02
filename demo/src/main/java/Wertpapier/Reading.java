package Wertpapier;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Reading {


		private String getPath() throws IOException {
				File file = new File(".");
				return file.getCanonicalPath();
		}
		public HashMap<String, String> readingCsv(String csvName) throws IOException {
				HashMap<String, String> csvData = new HashMap<String, String>();

				try (InputStream inputStream = getClass().getResourceAsStream(csvName);
						 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
						String line;
						while((line = reader.readLine()) != null) {
								String[] dataSplit = line.split(",");
								if(dataSplit.length > 1) {
										csvData.put(dataSplit[0], dataSplit[1]);
								}
						}

				}
						return csvData;
				}
		}

