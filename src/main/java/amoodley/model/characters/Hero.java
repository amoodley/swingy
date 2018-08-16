package amoodley.model.characters;

import amoodley.enums.ArmorType;
import amoodley.enums.CharacterType;
import amoodley.enums.HelmType;
import amoodley.enums.WeaponType;

public class Hero extends Character {

    protected int           _level;
    protected int           _experience;
    protected WeaponType    _weapon;
    protected ArmorType     _armor;
    protected HelmType      _helm;

    public Hero(){

    }

    public Hero(String name, CharacterType type, int level, int experience, int attack, int defense, int hitPoints, int maxHitPoints, int xPos, int yPos, WeaponType weapon, ArmorType armor, HelmType helm) {
        super(name, type, attack, defense, hitPoints, maxHitPoints, xPos, yPos);
        this._level = level;
        this._experience = experience;
        this._weapon = weapon;
        this._armor = armor;
        this._helm = helm;
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
