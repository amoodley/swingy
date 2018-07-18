package amoodley.model.characters;

public class Character {

    protected String        _name;
    protected int           _level;
    protected int           _experience;
    protected int           _attack;
    protected int           _defense;
    protected int           _hitPoints;
    protected int           _maxHitPoints;

    public Character(){

    }

    public Character(String name, int level, int experience, int attack, int defense, int hitPoints, int maxHitPoints){

        this._name = name;
        this._level = level;
        this._experience= experience;
        this._attack = attack;
        this._defense = defense;
        this._hitPoints = hitPoints;
        this._maxHitPoints = maxHitPoints;
    }

    public String getName(){
        return (this._name);
    }

    public int getLevel(){
        return (this._level);
    }

    public int getExperience(){
        return (this._experience);
    }

    public int getAttack(){
        return (this._attack);
    }

    public int getDefense(){
        return (this._defense);
    }

    public int getHitPoints(){
        return (this._hitPoints);
    }

    public int getMaxHitPoints(){
        return (this._maxHitPoints);
    }

    public void setName(String name){
        this._name = name;
    }

    public void setLevel(int level){
        this._level = level;
    }

    public void setExperience(int experience){
        this._experience = experience;
    }

    public void setAttack(int attack){
        this._attack = attack;
    }

    public void setDefense(int defense){
        this._defense = defense;
    }

    public void setHitPoints(int hitPoints){
        this._hitPoints = hitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints){
        this._maxHitPoints = maxHitPoints;
    }

}
