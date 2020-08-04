package ru.sapphirelife;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Baroness extends JavaPlugin {

    /**
     *
     * @author Black_Baroness
     * https://github.com/SiriusWhite74/BaronessLib
     * https://vk.com/black_baroness
     *
     */

    public static void kickPlayer(Player p, String... reason) {
        StringBuilder bye = new StringBuilder();
        for (String str : reason) {
            if (bye.toString().equals("")) {
                bye = new StringBuilder(str);
                continue;
            }
            bye.append("\n").append(str);
        }
        p.kickPlayer(bye.toString());
    }
}

