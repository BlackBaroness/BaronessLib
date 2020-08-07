package ru.sapphirelife;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Main class.
 *
 * @author Black_Baroness
 * @author github.com /SiriusWhite74/BaronessLib
 * @author vk.com /black_baroness
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

    /**
     * Checks for updates by comparing the weight of the current file and the weight of the link file.
     *
     * @param currentFile your file
     * @param url         the RAW url to file
     * @return false if weight is different
     */
    public static boolean checkUpdatesByWeight(File currentFile, String url) {
        try {
            URL updateUrl = new URL(url);
            URLConnection urlConnection = updateUrl.openConnection();
            urlConnection.connect();
            int actual = urlConnection.getContentLength();
            int now = (int) currentFile.length();
            if (actual == now) return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Downloads file from RAW url to specified path.
     *
     * @param path the path
     * @param url  the url
     */
    public static void downloadFile(String path, String url) {
        try {
            InputStream in = new URL(url).openStream();
            Files.copy(in, Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fill inventory with ItemStacks from a list.
     * If you want to break slot empty, just add null
     *
     * @param inventory the inventory
     * @param items     the list of ItemStacks
     * @return the filled inventory
     */
    public static Inventory fillInventory(Inventory inventory, List<ItemStack> items) {
        for (int i = 0; i <= inventory.getSize(); i++) {
            ItemStack item = items.get(i);
            if (item == null) continue;
            inventory.setItem(i, item);
        }
        return inventory;
    }

    /**
     * Returns how many items the player has (Material)
     *
     * @param player   the player
     * @param material the material
     * @return amount of specified items
     */
    public static int howManyItems(Player player, Material material) {
        int i = 0;
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null) continue;
            if (item.getType().equals(material)) i++;
        }
        return i;
    }

    /**
     * Returns how many items the player has (ItemStack)
     *
     * @param player    the player
     * @param itemStack the ItemStack
     * @return amount of specified items
     */
    public static int howManyItems(Player player, ItemStack itemStack) {
        int i = 0;
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null) continue;
            if (item.equals(itemStack)) i++;
        }
        return i;
    }

    /**
     * Takes the specified number of items from the player (Material)
     *
     * @param player   the player
     * @param material the material
     * @param amount   the amount
     */
    public static void removeItems(Player player, Material material, int amount) {
        for (int m = 0; m < player.getInventory().getContents().length; m++) {
            ItemStack item = player.getInventory().getItem(m);
            if (item == null) continue;

            if (item.getType().equals(material)) {
                int var = item.getAmount();
                if (var < amount) {
                    player.getInventory().setItem(m, new ItemStack(Material.AIR));
                    amount = amount - var;
                    continue;
                }
                item.setAmount(var - amount);
                player.getInventory().setItem(m, item);
                return;
            }
        }
    }

    /**
     * Takes the specified number of items from the player (ItemStack)
     *
     * @param player    the player
     * @param itemStack the ItemStack
     * @param amount    the amount
     */
    public static void removeItems(Player player, ItemStack itemStack, int amount) {
        for (int m = 0; m < player.getInventory().getContents().length; m++) {
            ItemStack item = player.getInventory().getItem(m);
            if (item == null) continue;

            if (item.equals(itemStack)) {
                int var = item.getAmount();
                if (var < amount) {
                    player.getInventory().setItem(m, new ItemStack(Material.AIR));
                    amount = amount - var;
                    continue;
                }
                item.setAmount(var - amount);
                player.getInventory().setItem(m, item);
                return;
            }
        }
    }
}

