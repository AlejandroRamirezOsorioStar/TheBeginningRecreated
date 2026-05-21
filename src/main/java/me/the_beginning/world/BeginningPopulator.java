package me.thebeginning.world;

import me.thebeginning.structures.StructureManager;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class BeginningPopulator extends BlockPopulator {

    @Override
    public void populate(
            World world,
            Random random,
            Chunk chunk) {

        if (random.nextInt(100) > 3) {
            return;
        }

        int chunkX = chunk.getX() * 16;
        int chunkZ = chunk.getZ() * 16;

        int y = 170;

        int structure =
                random.nextInt(5) + 1;

        StructureManager.pasteStructure(
                new Location(
                        world,
                        chunkX,
                        y,
                        chunkZ
                ),
                "island_" + structure
        );
    }
}