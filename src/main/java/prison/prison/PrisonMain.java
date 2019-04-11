package prison.prison;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class PrisonMain extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[Prison] Enabled");
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            getLogger().info("[Prison] Config not found, Creating one for you now!");
            saveDefaultConfig();
        } else {
            getLogger().info("[Prison] Config found, Loading!");
        }
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
