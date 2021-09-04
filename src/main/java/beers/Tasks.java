package beers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class Tasks {

    public List<Beer> getBeersFromJson() throws FileNotFoundException {

        Type REVIEW_TYPE = new TypeToken<List<Beer>>() {}.getType();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonReader jsonReader = new JsonReader(new FileReader("beers.json"));

        return gson.fromJson(jsonReader, REVIEW_TYPE);
    }

    public List<Brand> firstTask(List<Beer> data) {

        Set<String> brandList = data.stream().map(Beer::getBrand).collect(Collectors.toSet());
        List<Brand> brands = new ArrayList<>();

        brandList.forEach(brandName -> brands.add(new Brand(brandName, data.stream().filter(beer -> beer.getBrand().equals(brandName)).collect(Collectors.toList()))));

        return brands;

    }

    public List<Beer> secondTask(List<Beer> data, String beerType) {

        return data.stream().filter(beer -> beer.getType().equalsIgnoreCase(beerType)).collect(Collectors.toList());

    }

    public String thirdTask(List<Beer> data) {

        Set<String> brandList = data.stream().map(Beer::getBrand).collect(Collectors.toSet());
        List<Brand> brands = new ArrayList<>();

        brandList.forEach(brandName -> brands.add(new Brand(brandName, data.stream().filter(beer -> beer.getBrand().equals(brandName)).collect(Collectors.toList()))));

        Map<String, Double> brandAvarages = new HashMap<>();
        brands.forEach(brand -> brandAvarages.put(brand.getName(), brand.getBeers().stream().mapToInt(Beer::getPrice).average().getAsDouble()));

        return Collections.min(brandAvarages.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getKey();

    }

    public List<Beer> fourthTask(List<Beer> data) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ingredient = "";

        do {
            System.out.print("Adja meg a keresni kívánt hozzávalót: ");
            ingredient = br.readLine();

            if (ingredient.equals("víz")) {
                System.out.println("Minden sörben található víz!");
            }
        } while (ingredient.equals("") || ingredient.equals("víz"));

        String finalIngredient = ingredient.toLowerCase();

        return data.stream().filter(beer -> !beer.getIngredients().stream().map(Ingredient::getName).collect(Collectors.toList()).contains(finalIngredient)).collect(Collectors.toList());

    }

    public List<Beer> fifthTask(List<Beer> data) {

        Map<Beer, Double> beersSorted = new HashMap<>();
        List<Beer> result = new ArrayList<>();

        data.forEach(beer -> beersSorted.put(beer, 1.0 - (beer.getIngredients().stream().mapToDouble(Ingredient::getRatio).sum())));
        beersSorted.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(entry -> result.add(entry.getKey()));

        return result;

    }

    public Map<Integer, List<Beer>> sixthTask(List<Beer> data) {

        Map<Integer, List<Beer>> roundedPrices = new HashMap<>();

        Set<Integer> priceHundreds = data.stream().map(beer -> ((beer.getPrice() + 99) / 100) * 100).collect(Collectors.toSet());
        priceHundreds.forEach(hundred -> roundedPrices.put(hundred, new ArrayList<Beer>()));

        data.forEach(beer -> roundedPrices.get((((beer.getPrice() + 99) / 100) * 100)).add(beer));

        return roundedPrices;

    }

}
