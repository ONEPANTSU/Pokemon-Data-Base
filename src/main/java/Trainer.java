import pokemons.Pokemon;

import java.util.ArrayList;

public class Trainer {
    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    private String name;

    public Trainer(String name){
        this.name = name;
    }
    public Trainer(String name, ArrayList<Pokemon> pokemons){
        this.name = name;
        this.pokemons = pokemons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void chosePokemon(Pokemon pokemon){
        System.out.print(this.getName() + ":\t");
        pokemon.chosePokemon();
    }
}
