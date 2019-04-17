package prison.prison;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class utils {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static double getMoney(UUID uuid) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        return PrisonMain.econ.getBalance(player);
    }

    public static void takeMoney(Player p, double amount) {
        double money = getMoney(p.getUniqueId());
        PrisonMain.econ.withdrawPlayer(p, amount);
    }


}
