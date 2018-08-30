package amoodley.model.characters;

import amoodley.enums.ArmorType;
import amoodley.enums.CharacterType;
import amoodley.enums.HelmType;
import amoodley.enums.WeaponType;
import amoodley.utilities.Coordinates;

public class Hero {


    private static int      _idCounter = 0;
    protected int           _id = 0;

    protected String        _name;
    protected int           _level;
    protected int           _experience;
    protected CharacterType _type;
    protected int           _attack;
    protected int           _defense;
    protected int           _hitPoints;

    protected Coordinates   _coordinates;

    protected WeaponType    _weapon;
    protected ArmorType     _armor;
    protected HelmType      _helm;


    public Hero(){

    }

    public Hero(String name, CharacterType type, int level, int experience, int attack, int defense, int hitPoints, WeaponType weapon, ArmorType armor, HelmType helm) {

        _id = setNextId();

        this._name = name;
        this._type = type;
        this._level = level;
        this._experience = experience;
        this._attack = attack;
        this._defense = defense;
        this._hitPoints = hitPoints;

        this._weapon = weapon;
        this._armor = armor;
        this._helm = helm;

        _coordinates = new Coordinates(0,0);
    }

    public int getId(){
        return _id;
    }

    public String getName(){
        return (this._name);
    }

    public CharacterType getType(){
        return (this._type);
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

    public Coordinates getCoordinates(){

        return (this._coordinates);
    }

    public WeaponType getWeapon(){
        return (this._weapon);
    }

    public ArmorType getArmor(){
        return (this._armor);
    }

    public HelmType getHelm(){
        return (this._helm);
    }

    private int setNextId(){

        return (++this._idCounter);
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

    public void setCoordinates(Coordinates coordinates){

        this._coordinates = coordinates;
    }

    public void setWeapon(WeaponType weapon){
        this._weapon = weapon;
    }

    public void setArmor(ArmorType armor){
        this._armor = armor;
    }

    public void setHelm(HelmType helm){
        this._helm = helm;
    }
}
