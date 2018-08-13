package amoodley.model.characters;

public class Hero extends Character {

    protected int           _level;
    protected int           _experience;

    public Hero(){

    }

    public Hero(String name, int level, int experience, int attack, int defense, int hitPoints, int maxHitPoints, int xPos, int yPos) {
        super(name, attack, defense, hitPoints, maxHitPoints, xPos, yPos);
        this._level = level;
        this._experience = experience;
    }

    public int getLevel(){
        return (this._level);
    }

    public int getExperience(){
        return (this._experience);
    }

    public void setLevel(int level){
        this._level = level;
    }

    public void setExperience(int experience){
        this._experience = experience;
    }
}
