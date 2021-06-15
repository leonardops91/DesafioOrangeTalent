package br.com.desafio.carManager.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class VehicleService {
	private static String brandKey = "2";
	private static String modelKey = "4";
	private static String yearKey;
	
	public static boolean isVehicleValid(String brand, String model, String year) {
		isBrandValid(brand);
		isModelValid(model);
		return true;
	}

	private static void isBrandValid(String brand) {
		String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
		searchVehicle(brand, url);
	}

	private static String searchVehicle(String search, String url) {
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<?> Response = restTemplate.getForObject(url, ArrayList.class );
		System.out.println(Response);
		for(int i = 0; i<Response.size(); i++) {
			if(Response.get(i).toString().contains(search)) {
				LinkedHashMap<String, String> responseMap = (LinkedHashMap<String, String>) Response.get(i);
				String key = responseMap.get("codigo");
				System.out.println(key);
				return key;
			}
		}
		return null;
	}

	private static void isModelValid(String model) {
		String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas/"+brandKey+"/modelos";
		searchVehicle(model, url);
	}

	public static double getPrice() {
		// TODO Auto-generated method stub
		return 3;
	}

}
