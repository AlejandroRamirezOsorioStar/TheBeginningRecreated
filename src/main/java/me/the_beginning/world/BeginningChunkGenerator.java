package me.thebeginning.world;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class BeginningChunkGenerator extends ChunkGenerator {

    @Override
    public ChunkData generateChunkData(
            World world,
            Random random,
            int chunkX,
            int chunkZ,
            BiomeGrid biome) {

        ChunkData chunk = createChunkData(world);

        int centerX = chunkX * 16;
        int centerZ = chunkZ * 16;

        for (int x = 0; x < 16; x++) {

            for (int z = 0; z < 16; z++) {

                int realX = centerX + x;
                int realZ = centerZ + z;

                double continentalNoise =
                        Math.sin(realX * 0.0025)
                      + Math.cos(realZ * 0.0025)
                      + Math.sin((realX + realZ) * 0.0015);

                double detailNoise =
                        Math.sin(realX * 0.02)
                      * Math.cos(realZ * 0.02);

                double combined =
                        continentalNoise * 25
                      + detailNoise * 8;

                int baseHeight = 108;

                int terrainHeight =
                        baseHeight + (int) combined;

                boolean generateLand =
                        combined > -6;

                if (generateLand) {

                    int bottom = terrainHeight - 28;

                    for (int y = bottom;
                         y <= terrainHeight;
                         y++) {

                        if (y >= terrainHeight - 1) {

                            chunk.setBlock(
                                    x,
                                    y,
                                    z,
                                    Material.PURPUR_BLOCK
                            );

                        } else if (y >= terrainHeight - 5) {

                            chunk.setBlock(
                                    x,
                                    y,
                                    z,
                                    Material.END_STONE
                            );

                        } else {

                            chunk.setBlock(
                                    x,
                                    y,
                                    z,
                                    Material.PURPUR_BLOCK
                            );
                        }
                    }
                }
            }
        }

        return chunk;
    }
}

@Override
public java.util.List<BlockPopulator>
getDefaultPopulators(World world) {

    return java.util.Collections.singletonList(
            new BeginningPopulator()
    );
}