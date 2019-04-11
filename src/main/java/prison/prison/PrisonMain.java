package prison.prison;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import prison.prison.commands.help;

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

        this.getCommand("help").setExecutor(new help());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        getLogger().info("[Prison] Disabled");
        // Plugin shutdown logic
    }


}
