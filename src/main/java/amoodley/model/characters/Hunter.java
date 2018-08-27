package amoodley.model.characters;

import amoodley.enums.ArmorType;
import amoodley.enums.CharacterType;
import amoodley.enums.HelmType;
import amoodley.enums.WeaponType;

public class Hunter extends Hero{

    public Hunter(String name, CharacterType type, int level, int experience, int attack, int defense, int hitPoints, WeaponType weapon, ArmorType armor, HelmType helm, String icon) {
        super(name, type, level, experience, attack, defense, hitPoints, weapon, armor, helm, icon);
    }

}
