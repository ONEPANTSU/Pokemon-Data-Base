package dbCore;

import pokemons.ElectricalPokemon;
import pokemons.Pokemon;

import java.util.ArrayList;

public class DBManager {

    DBCore db = new DBCore();


    public void printElecticalPokemons(){
        ArrayList<ElectricalPokemon> result = db.dbRead("SELECT name, power, electricalPower, hits, alive FROM Pokemon " +
                                                        "INNER JOIN NormalPokemon ON Pokemon.id = NormalPokemon.id " +
                                                        "INNER JOIN ElectricalPokemon ON NormalPokemon.id = ElectricalPokemon.id;",
                                                        ElectricalPokemon.class);

        System.out.println(result.toString());
    }

}
