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

    public static Hero newHero(String name, String type, String level, String xp, String attack, String defense, String hp, WeaponType weapon, ArmorType armor, HelmType helm){

        int _level = 0;
        int _xp = 0;
        int _attack = 0;
        int _defense = 0;
        int _hp = 0;

        try {

            _level = Integer.parseInt(level);
            _xp = Integer.parseInt(xp);
            _attack = Integer.parseInt(attack);
            _defense = Integer.parseInt(defense);
            _hp = Integer.parseInt(hp);


            CharacterType tempCharacterType = CharacterType.valueOf(type);
            HelmType tempHelmType = HelmType.nasal;
            WeaponType tempWeaponType = WeaponType.spear;
            ArmorType tempArmorType = ArmorType.jacket;

            switch(tempCharacterType){
                case warrior:
                    return (new Warrior(name, tempCharacterType, _level, _xp, _attack, _defense, _hp, tempWeaponType, tempArmorType, tempHelmType));
                case hunter:
                    return (new Hunter(name, tempCharacterType, _level, _xp, _attack, _defense, _hp, tempWeaponType, tempArmorType, tempHelmType));
                case mage:
                    return (new Mage(name, tempCharacterType, _level, _xp, _attack, _defense, _hp, tempWeaponType, tempArmorType, tempHelmType));
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


        CharacterType tempCharacterType = type;
        WeaponType tempWeaponType = WeaponType.spear;
        ArmorType tempArmorType = ArmorType.jacket;
        HelmType tempHelmType = HelmType.nasal;

        switch (tempCharacterType){
            case warrior:
                return (new Warrior(name, tempCharacterType, level, xp, attack, defense, hp, tempWeaponType, tempArmorType, tempHelmType));
            case hunter:
                return (new Hunter(name, tempCharacterType, level, xp, attack, defense, hp, tempWeaponType, tempArmorType, tempHelmType));
            case mage:
                return (new Mage(name, tempCharacterType, level, xp, attack, defense, hp, tempWeaponType, tempArmorType, tempHelmType));
            default:
                break;
        }
        return (null);
    }
}
