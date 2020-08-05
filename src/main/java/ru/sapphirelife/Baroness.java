package ru.sapphirelife;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Black_Baroness
 * https://github.com/SiriusWhite74/BaronessLib
 * https://vk.com/black_baroness
 */

public class Baroness extends JavaPlugin {

    /**
     * кикает игрока с сервера по указанной причине (мультистрочность)
     *
     * @param p      игрок
     * @param reason причина
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


    /**
     * проверяет, совпадает ли IP игрока с указанным
     *
     * @param p  игрок
     * @param ip IP, с которым идёт сравнение
     * @return совпадает ли IP
     */

    public static boolean checkIP(Player p, String ip) {
        ip = "/" + ip;
        return p.getAddress().getAddress().toString().equals(ip);
    }
}

