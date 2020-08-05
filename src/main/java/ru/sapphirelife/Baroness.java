package ru.sapphirelife;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class.
 *
 * @author Black_Baroness  https://github.com/SiriusWhite74/BaronessLib https://vk.com/black_baroness
 */
public class Baroness extends JavaPlugin {

    /**
     * Kicks player with multiple rows as reason.
     *
     * @param player the player
     * @param reason the reason
     */
    public static void kickPlayer(Player player, String... reason) {
        StringBuilder bye = new StringBuilder();
        for (String str : reason) {
            if (bye.toString().equals("")) {
                bye = new StringBuilder(str);
                continue;
            }
            bye.append("\n").append(str);
        }
        player.kickPlayer(bye.toString());
    }


    /**
     * Checks whether the player's IP matches the specified one.
     *
     * @param player the player
     * @param ip     the ip
     * @return does it match
     */
    public static boolean checkIP(Player player, String ip) {
        ip = "/" + ip;
        return player.getAddress().getAddress().toString().equals(ip);
    }
}

