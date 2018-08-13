package amoodley.interfaces;

import amoodley.model.characters.Hero;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface IDataProvider {

    public List<Hero> getHeroList();

    public Boolean insertHero(Hero hero);

    public Boolean updateHero(Hero hero);

    public Boolean deleteHero(Hero hero);
}
