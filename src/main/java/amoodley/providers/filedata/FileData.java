package amoodley.providers.filedata;

import amoodley.config.Config;
import amoodley.interfaces.IDataProvider;
import amoodley.model.characters.Hero;
import amoodley.providers.Cache;

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
}
