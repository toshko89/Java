package Classes.PokémonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    String name;
    int badges = 0;
    List<Pokemon> pokemons = new ArrayList<>();

    public Trainer(String name, int badges, Pokemon pokemon) {
        this.name = name;
        this.badges = badges;
        this.pokemons.add(pokemon);
    }
}
