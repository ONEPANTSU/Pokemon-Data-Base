package pokemons;

public class Pokemon {
    public String name;
    public int hits = 25;
    public int alive = 1;

    public Pokemon(){}

    public Pokemon(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "\nPokemon:\n" +
                "name\t=\t'" + name + '\'' +
                "\nhits\t=\t" + hits +
                "\nalive\t=\t" + alive +
                '\n';
    }

    public void attack(Pokemon enemy, int damage){
        if(this.alive == 1) {
            enemy.setHits(enemy.getHits() - damage);
            if (enemy.hits <= 0) {
                enemy.alive = 0;
                System.out.println(enemy.name + " losed!");
            }
        }
        else{
            System.out.println(this.name + "is tired!");
        }
    }
    public Pokemon chosePokemon(){
        System.out.println(name + "! I chose you!");
        return this;
    }

}
