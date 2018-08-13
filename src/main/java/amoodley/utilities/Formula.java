package amoodley.utilities;

public class Formula {

    public static int sizeMap(int level){

        // Formula: (level-1)*5+10-(level%2)
        int size = 0;
        size = (((level - 1) * 5) + 10) - (level % 2);
        return (size);
    }

    public static int getExperience(int level){

        // Formula: level*1000+(level − 1)^2*450
        double experience = level * 1000 + Math.pow(((double)level) - 1, 2) * 450;
        return (int)experience;
    }

    public static int getNumberOfEnemies(int level){

        int ret = 0;
        ret = level + 5;
        return (ret);
    }
}
