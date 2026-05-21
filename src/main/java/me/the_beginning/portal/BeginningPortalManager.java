package me.thebeginning.portal;

import me.thebeginning.structures.StructureManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Random;

public class BeginningPortalManager {

    private static boolean generated = false;

    public static void generatePortal() {

        if (generated) {
            return;
        }

        World world =
                Bukkit.getWorld("world");

        if (world == null) {
            return;
        }

        Random random =
                new Random();

        int x =
                random.nextInt(5000)
                - 2500;

        int z =
                random.nextInt(5000)
                - 2500;

        int y =
                world.getHighestBlockYAt(x, z)
                + 1;

        StructureManager.pasteStructure(
                new Location(world, x, y, z),
                "portal"
        );

        generated = true;

        Bukkit.getLogger().info(
                "[TheBeginning] Portal generado en "
                + x + " "
                + y + " "
                + z
        );
    }
}