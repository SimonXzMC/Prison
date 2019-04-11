package prison.prison.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class help implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if ((sender.hasPermission("prison.help")) && (command.getName().equalsIgnoreCase("help"))) {
            sender.sendMessage("");
            sender.sendMessage(colorize("&2&m-----[ &aPrison Help &2&m]-----"));
            sender.sendMessage(colorize("   &b/rankup &7Progress through the ranks!"));
            sender.sendMessage("");
        }
        return true;
    }



    private String colorize(String todo){
        return ChatColor.translateAlternateColorCodes('&', todo);
    }
}
