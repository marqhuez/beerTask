package beers;

import java.util.List;

public class Brand {
    private String name;
    private List<Beer> beers;

    public Brand(String name, List<Beer> beerList) {
        this.name = name;
        this.beers = beerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }
}
