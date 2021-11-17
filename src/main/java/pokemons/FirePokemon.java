package pokemons;

public class FirePokemon extends NormalPokemon{

    public int firePower;

    public FirePokemon(){
        super();
    }
    public FirePokemon(String name, int power, int firePower) {
        super(name, power);
        this.firePower = firePower;
    }

    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }


    @Override
    public String toString() {
        return super.toString() +
                "firePower\t=\t" + firePower +
                '\n';
    }

    public void Ember(Pokemon enemy){
        System.out.println(this.getName() + "! Use ember to " + enemy.getName() + "!");
        attack(enemy, firePower);
    }

}
