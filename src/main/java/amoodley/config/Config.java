package amoodley.config;

import amoodley.enums.AppDisplay;

public class Config {

    public static AppDisplay AppDisplayMode = AppDisplay.console;
    public static boolean IS_DEVELOPMENT = false;
    public static String HERO_TEXT_FILE_NAME = "hero-stats.txt";

    public static void init(String[] configs){

        if (configs.length > 0){

            for (String config: configs){

                config = config.trim();
                if (config != null){
                    if (config.equalsIgnoreCase("gui") ||
                        config.equalsIgnoreCase("console")){
                        Config.setAppDisplay(config);
                    }
                    if (config.equalsIgnoreCase("dev")){
                        Config.IS_DEVELOPMENT = true;
                    }
                }
            }
        }
    }

    public static void setAppDisplay(String appDisplay){

        try{
            AppDisplayMode = AppDisplay.valueOf(appDisplay);
        } catch (Exception e){
            
        }
    }
}
