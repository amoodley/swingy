package amoodley.providers;

import amoodley.config.Config;
import amoodley.model.characters.Hero;

import java.util.List;

public class Cache {

    public static List<Hero> HeroList = null;

    public static void init(){

        DataProvider dataProvider = new DataProvider(Config.DATA_PROVIDER);
        HeroList = dataProvider.getHeroList();
    }
}
