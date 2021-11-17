package pokemons;

public class ElectricalPokemon extends NormalPokemon{

    public int electricalPower;

    public ElectricalPokemon(){
        super();
    }
    public ElectricalPokemon(String name, int power, int electricalPower) {
        super(name, power);
        this.electricalPower = electricalPower;
    }

    @Override
    public String toString() {
        return super.toString() +
                "electricalPower\t=\t" + electricalPower +
                '\n';
    }

    public int getElectricalPower() {
        return electricalPower;
    }

    public void setElectricalPower(int electricalPower) {
        this.electricalPower = electricalPower;
    }

    public void Thunderbolt(Pokemon enemy){
        System.out.println(this.getName() + "! Use thunderbolt to " + enemy.getName() + "!");
        attack(enemy, electricalPower);
    }
}
