import dbCore.DBManager;
import pokemons.ElectricalPokemon;
import pokemons.FirePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;

public class Main {

    public static void main(String[] args) {

        Trainer vanya = new Trainer("Vanya");
        Trainer rocketTeam = new Trainer("Rocket-Team");

        Pokemon magicarp = new Pokemon("Magicarp");
        NormalPokemon ratata = new NormalPokemon("Ratata", 5);
        ElectricalPokemon pikachu = new ElectricalPokemon("Pikachu", 8, 10);
        FirePokemon charmander = new FirePokemon("Charmander", 9, 8);

        vanya.addPokemon(pikachu);
        vanya.addPokemon(charmander);

        rocketTeam.addPokemon(magicarp);
        rocketTeam.addPokemon(ratata);

        for(int i = 0; i < vanya.getPokemons().size(); i++){
            vanya.chosePokemon(vanya.getPokemons().get(i));
        }

        for(int i = 0; i < rocketTeam.getPokemons().size(); i++){
            rocketTeam.chosePokemon(rocketTeam.getPokemons().get(i));
        }

        DBManager dbManager = new DBManager();
        dbManager.printElecticalPokemons();

    }

}
