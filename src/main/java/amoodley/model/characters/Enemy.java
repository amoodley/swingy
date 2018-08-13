package amoodley.model.characters;

public class Enemy extends Character {

    public Enemy(){

    }

    public Enemy(String name, int level, int experience, int attack, int defense, int hitPoints, int maxHitPoints, int xPos, int yPos) {
        super(name, attack, defense, hitPoints, maxHitPoints, xPos, yPos);
    }
}
