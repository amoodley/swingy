package amoodley.providers;

import amoodley.config.Config;
import amoodley.interfaces.IDataProvider;
import amoodley.model.characters.Hero;
import amoodley.interfaces.IDataProvider;

import java.util.List;

public class DataProvider implements IDataProvider {

    private IDataProvider _provider;

    public DataProvider (){

    }

    public DataProvider (DataProviderType dataProviderType){

        if (Config.DATA_PROVIDER == dataProviderType){
            this._provider = new FileData(Config.HERO_TEXT_FILE_NAME);
        }
    }

    public List<Hero> getHeroList(){

        if (this._provider == null)
            return (null);
        return (this._provider.getHeroList());

    }

    public Boolean insertHero(Hero hero){

        if (this._provider == null)
            return (null);
        return (this._provider.insertHero(hero));
    }

    public Boolean updateHero(Hero hero){

        if (this._provider == null)
            return (null);
        return (this._provider.updateHero(hero));
    }

    public Boolean deleteHero(Hero hero){
        if (this._provider == null)
            return (null);
        return (this._provider.deleteHero(hero));
    }
}
