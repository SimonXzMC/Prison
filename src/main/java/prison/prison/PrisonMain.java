package prison.prison;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import prison.prison.commands.help;

import java.io.File;

public final class PrisonMain extends JavaPlugin {

    public static PrisonMain instance;
    public static Economy econ = null;
    public static Chat chat = null;

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

        //RANKUP CODE
        instance = this;
        config.setup();
        setupEconomy();
        setupChat();
        Bukkit.getPluginManager().registerEvents(this, this);

    }

    private boolean setupEconomy(){
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = (Economy)rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat(){
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = (Chat)rsp.getProvider();
        return chat != null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rankup")) {
            Player p = null;
            if ((sender instanceof Player)) {
                p = (Player)sender;
            }
            if (args.length == 0) {
                if (p != null) {
                    utils.openRanks(p);
                } else {
                    sender.sendMessage(utils.color(config.c.getString("no_console")));
                }
            }
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("[Prison] Disabled");
        // Plugin shutdown logic
    }


}
