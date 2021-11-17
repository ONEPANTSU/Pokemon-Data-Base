package pokemons;

public class NormalPokemon extends Pokemon {

    public int power = 15;

    public NormalPokemon(){
        super();
    }
    public NormalPokemon(String name, int power) {
        super(name);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {

        return super.toString() +
                "power\t=\t" + power +
                '\n';
    }

    public void bite(Pokemon enemy){
        System.out.println(this.getName() + "! Bite " + enemy.getName() + "!");
        attack(enemy, power);
    }

}
