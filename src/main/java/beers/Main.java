package beers;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Tasks tasks = new Tasks();
        List<Beer> data = tasks.getBeersFromJson();

        List<Brand> groupedByBrands = tasks.firstTask(data);
        List<Beer> filteredByTypes = tasks.secondTask(data, BeerType.buza);
        String cheapestBrand = tasks.thirdTask(data);
        List<Beer> beersLackingIngredient = tasks.fourthTask(data);
        List<Beer> sortedByWaterRatio = tasks.fifthTask(data);
        Map<Integer, List<Beer>> roundedToHundreds = tasks.sixthTask(data);

    }
}
