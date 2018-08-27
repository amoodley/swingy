package amoodley.model.characters;

import amoodley.enums.CharacterType;
import amoodley.utilities.Coordinates;

public class Character {


    protected String        _name;
    protected CharacterType _type;
    protected int           _attack;
    protected int           _defense;
    protected int           _hitPoints;
    protected int           _maxHitPoints;
    protected Coordinates   _coordinates;


    public Character(){

    }

    public Character(String name, CharacterType type, int attack, int defense, int hitPoints){


        this._name = name;
        this._type = type;
        this._attack = attack;
        this._defense = defense;
        this._hitPoints = hitPoints;
        _coordinates = new Coordinates(0,0);
    }


    public void setCoordinates(Coordinates coordinates){

        this._coordinates = coordinates;
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

    public Coordinates getCoordinates(){

        return (this._coordinates);
    }
}
