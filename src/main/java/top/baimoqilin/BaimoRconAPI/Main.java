package top.baimoqilin.BaimoRconAPI;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        int pluginId = 18405;
        Metrics metrics = new Metrics(this, pluginId);
        getCommand("baimoapi").setExecutor(new CommandListener());
        getLogger().info("BaimoRconAPI enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("BaimoRconAPI disabled");
    }
}