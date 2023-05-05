package top.baimoqilin.BaimoRconAPI;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getCommand("baimoapi").setExecutor(new CommandListener());
        getLogger().info("BaimoRconAPI enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("BaimoRconAPI disabled");
    }
}