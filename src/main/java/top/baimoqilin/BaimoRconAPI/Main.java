package top.baimoqilin.BaimoRconAPI;

import org.bukkit.plugin.java.JavaPlugin;
import top.baimoqilin.BaimoRconAPI.Metrics;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        int pluginId = 18405;
        Metrics metrics = new Metrics(this, pluginId);
        getCommand("baimoapi").setExecutor(new CommandListener());
        
        saveDefaultConfig();
        reloadConfig();
        
        getLogger().info("BaimoRconAPI enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("BaimoRconAPI disabled");
    }
    
    public FileConfiguration getConfig() {
        return getConfig();
    }

}