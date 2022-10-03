package Classes.PokémonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Trainer> allTrainers = new LinkedHashMap();

        while (!input.equals("Tournament")) {
            String[] pokemons = input.split(" ");
            String trainerName = pokemons[0];
            String pokemonName = pokemons[1];
            String pokemonElement = pokemons[2];
            int pokemonHealth = Integer.parseInt(pokemons[3]);
            Pokemon newPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!allTrainers.containsKey(trainerName)) {
                Trainer newTrainer = new Trainer(trainerName, 0, newPokemon);
                allTrainers.put(trainerName, newTrainer);
            } else {
                allTrainers.get(trainerName).pokemons.add(newPokemon);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            String ele = input;
            for (var entry : allTrainers.entrySet()) {
                Pokemon pokemon = entry.getValue().pokemons
                        .stream().filter(p -> p.element.equals(ele)).findFirst().orElse(null);
                if (pokemon != null) {
                    entry.getValue().badges += 1;
                } else {
                    try{
                        for (Pokemon pokemon1 : entry.getValue().pokemons) {
                            if (pokemon1.health >= 10 || pokemon1.health <= 10) {
                                pokemon1.health -= 10;
                            }
                            if (pokemon1.health <= 0) {
                                entry.getValue().pokemons.remove(pokemon1);
                            }
                        }
                    }catch (Exception e){
                        continue;
                    }
                }
            }

            input = scanner.nextLine();
        }

       List<Trainer> result = allTrainers.values().stream().sorted((x1,x2)->x2.badges-x1.badges)
               .collect(Collectors.toList());

        for (Trainer trainer : result) {
            System.out.printf("%s %d %d%n",trainer.name,trainer.badges,trainer.pokemons.size());
        }
    }
}
