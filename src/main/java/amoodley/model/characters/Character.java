package amoodley.model.characters;

import amoodley.enums.CharacterType;

public class Character {


    protected String        _name;
    protected CharacterType _type;
    protected int           _attack;
    protected int           _defense;
    protected int           _hitPoints;
    protected int           _maxHitPoints;
    protected int           _xPos;
    protected int           _yPos;


    public Character(){

    }

    public Character(String name, CharacterType type, int attack, int defense, int hitPoints, int maxHitPoints, int xPos, int yPos){


        this._name = name;
        this._type = type;
        this._attack = attack;
        this._defense = defense;
        this._hitPoints = hitPoints;
        this._maxHitPoints = maxHitPoints;
        this._xPos = xPos;
        this._yPos = yPos;
    }



    public String getName(){
        return (this._name);
    }

    public CharacterType getType(){
        return (this._type);
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
