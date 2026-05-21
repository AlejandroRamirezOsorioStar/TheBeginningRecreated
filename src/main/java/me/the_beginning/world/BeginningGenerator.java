package me.thebeginning.world;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

public class BeginningGenerator {

    public static void createWorld() {

        if (Bukkit.getWorld("the_beginning") != null) {
            return;
        }

        WorldCreator creator = new WorldCreator("the_beginning");

        creator.environment(World.Environment.THE_END);
        creator.type(WorldType.NORMAL);

        creator.generator(new BeginningChunkGenerator());

        Bukkit.createWorld(creator);
    }
}