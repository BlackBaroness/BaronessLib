package ru.sapphirelife;

import org.bukkit.entity.Player;

/**
 * This is a 2D region.
 * It has 4 vertices - X1, X2, Z1, Z2.
 * You can create a region and check whether the player is in it.
 */
public class Region {

    private final int X1;
    private final int X2;
    private final int Z1;
    private final int Z2;
    private String name;

    /**
     * Instantiates a new Region.
     *
     * @param X1 the x 1
     * @param X2 the x 2
     * @param Z1 the z 1
     * @param Z2 the z 2
     */
    public Region(int X1, int X2, int Z1, int Z2) {
        this.X1 = X1;
        this.X2 = X2;
        this.Z1 = Z1;
        this.Z2 = Z2;
    }

    /**
     * Returns whether the player is in this 2D area.
     * Please note that the height does not matter here.
     *
     * @param player the player
     * @return is player in region
     */
    public boolean isInRegion(Player player) {
        int x = player.getLocation().getBlockX();
        int z = player.getLocation().getBlockZ();

        return
                X1 <= x && x <= X2 &&
                        Z1 <= z && z <= Z2;
    }

    /**
     * You can set the name of this region, if desired.
     *
     * @param name the name of region
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets regions's name.
     *
     * @return the name
     */
    public String getName() {
        if (name == null) return "empty";
        return name;
    }
}
