package amoodley.factories;

import amoodley.enums.ArmorType;
import amoodley.enums.CharacterType;
import amoodley.enums.HelmType;
import amoodley.enums.WeaponType;
import amoodley.model.characters.Hero;
import amoodley.model.characters.Hunter;
import amoodley.model.characters.Warrior;
import amoodley.model.characters.Mage;

public class HeroFactory {

    public static Hero newHero(String name, String type, String level, String xp, String attack, String defense, String hp, ){

        int _level = 0;
        int _xp = 0;
        int _attack = 0;
        int _defense = 0;
        int _hp = 0;
        int _maxHP = 0;
        int _xPos = 0;
        int _yPos = 0;

        try {

            _level = Integer.parseInt(level);
            _xp = Integer.parseInt(xp);
            _attack = Integer.parseInt(attack);
            _defense = Integer.parseInt(defense);
            _hp = Integer.parseInt(hp);
            _maxHP = Integer.parseInt(maxHP);
            _xPos = Integer.parseInt(xPos);
            _yPos = Integer.parseInt(yPos);


            CharacterType tempCharacterType = CharacterType.valueOf(type);
            HelmType tempHelmType = HelmType.nasal;
            WeaponType tempWeaponType = WeaponType.spear;
            ArmorType tempArmorType = ArmorType.jacket;

            switch(tempCharacterType){
                case warrior:
                    return (new Warrior(name, tempCharacterType, _level, _xp, _attack, _defense, _hp, tempWeaponType, tempArmorType, tempHelmType, icon));
                case hunter:
                    return (new Hunter(name, _level, _xp, _attack, _defense, _hp, _maxHP, _xPos, _yPos));
                case mage:
                    return (new Mage(name, _level, _xp, _attack, _defense, _hp, _maxHP, _xPos, _yPos));
                default:
                    break;
            }

        } catch (Exception e){
            System.out.println("Error creating hero: " + e.getMessage());
        }
        return (null);
    }

    public static Hero newHero(String name, CharacterType type){

        int level = 0;
        int xp = 0;
        int attack = 15;
        int defense = 10;
        int hp = 50;
        int maxHP = 50;
        int xPos = 0;
        int yPos = 0;

        CharacterType tempCharacterType = type;

        switch (tempCharacterType){
            case warrior:
                return (new Warrior(name, level, xp, attack, defense, hp, maxHP, xPos, yPos));
            case hunter:
                return (new Hunter(name, level, xp, attack, defense, hp, maxHP, xPos, yPos));
            case mage:
                return (new Mage(name, level, xp, attack, defense, hp, maxHP, xPos, yPos));
            default:
                break;
        }
        return (null);
    }
}
