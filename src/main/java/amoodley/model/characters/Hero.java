package amoodley.model.characters;

import amoodley.enums.ArmorType;
import amoodley.enums.CharacterType;
import amoodley.enums.HelmType;
import amoodley.enums.WeaponType;

public class Hero extends Character {


    private static int      _idCounter = 0;
    protected int           _id = 0;

    protected int           _level;
    protected int           _experience;
    protected WeaponType    _weapon;
    protected ArmorType     _armor;
    protected HelmType      _helm;

    protected String        _icon;


    public Hero(){

    }

    public Hero(String name, CharacterType type, int level, int experience, int attack, int defense, int hitPoints, WeaponType weapon, ArmorType armor, HelmType helm, String icon) {
        super(name, type, attack, defense, hitPoints);
        this._icon = icon;
        _id = setNextId();
        this._level = level;
        this._experience = experience;
        this._weapon = weapon;
        this._armor = armor;
        this._helm = helm;
    }

    private int setNextId(){

        return (++this._idCounter);
    }

    public int getId(){
        return _id;
    }

    public int getLevel(){
        return (this._level);
    }

    public int getExperience(){
        return (this._experience);
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

    public void setLevel(int level){
        this._level = level;
    }

    public void setExperience(int experience){
        this._experience = experience;
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
