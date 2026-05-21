package me.thebeginning.ytic;

import me.thebeginning.structures.StructureManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class YticManager {

    private static boolean generated = false;

    public static void generateYtic() {

        if (generated) {
            return;
        }

        World world =
                Bukkit.getWorld("the_beginning");

        if (world == null) {
            return;
        }

        StructureManager.pasteStructure(
                new Location(world, 0, 120, 0),
                "ytic"
        );

        generated = true;

        Bukkit.getLogger().info(
                "[TheBeginning] Ytic generado."
        );
    }
}