package amoodley.providers.filedata;

import amoodley.config.Config;
import amoodley.enums.ArmorType;
import amoodley.enums.HelmType;
import amoodley.enums.WeaponType;
import amoodley.factories.HeroFactory;
import amoodley.interfaces.IDataProvider;
import amoodley.model.characters.Hero;
import amoodley.providers.Cache;
import amoodley.utilities.WriteFile;
import amoodley.utilities.readFile;

import java.util.ArrayList;
import java.util.List;

public class FileData implements IDataProvider {

    private String _file;
    private List<Hero> _heroList;

    public FileData(String filename){

        this._file = filename;
        this._heroList = null;
    }

    private void initHeroList(){

        if (this._heroList == null){
            this._heroList = new ArrayList<Hero>();
        }
    }

    private void insertHeroHelper(Hero _hero, Boolean append){

        String hero = (_hero.getName() + "," + _hero.getType() + "," + _hero.getLevel() + "," + _hero.getExperience() + "," + _hero.getAttack() + "," + _hero.getDefense() + ","
                + _hero.getHitPoints() + "," + _hero.getWeapon() + "," + _hero.getArmor() + "," + _hero.getHelm() + "\n");
        WriteFile.write(Config.HERO_TEXT_FILE_NAME, hero, append);
        Cache.init();
    }

    public List<Hero> getHeroList(){
        String fileInfo = readFile.getContent(this._file);
        String[] fileInfoArray = null;
        if (fileInfo != null && (fileInfoArray = fileInfo.split("\n")) != null){

            for (String info : fileInfoArray){

                String[] heroInfo = null;
                heroInfo = info.split(",");
                if (heroInfo.length == 10){

                    this.initHeroList();

                    String name = heroInfo[0];
                    String type = heroInfo[1];
                    String level = heroInfo[2];
                    String experience = heroInfo[3];
                    String attack = heroInfo[4];
                    String defense = heroInfo[5];
                    String hitPoints = heroInfo[6];
                    String weapon = heroInfo[7];
                    String armor = heroInfo[8];
                    String helm = heroInfo[9];

                    WeaponType tempWeaponType = WeaponType.valueOf(weapon);
                    ArmorType tempArmorType = ArmorType.valueOf(armor);
                    HelmType tempHelmType = HelmType.valueOf(helm);

                    Hero hero = HeroFactory.newHero(name, type, level, experience, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType);
                    if (hero != null){
                        this._heroList.add(hero);
                    }
                }
            }
        }
        return (this._heroList);
    }

    public Boolean insertHero(Hero hero){
        this.insertHeroHelper(hero, true);
        return (true);
    }

    public Boolean updateHero(Hero hero){

        List<Hero> heroList = Cache.HeroList;
        WriteFile.write(Config.HERO_TEXT_FILE_NAME, "", false);

        if (heroList == null){
            return (false);
        }
        for (Hero h: heroList){

            if (h.getId() == hero.getId()){
                this.insertHeroHelper(hero, true);
            } else {
                this.insertHeroHelper(h, true);
            }
        }
        return (true);
    }

    public Boolean deleteHero(Hero hero){

        return (false);
    }
}
