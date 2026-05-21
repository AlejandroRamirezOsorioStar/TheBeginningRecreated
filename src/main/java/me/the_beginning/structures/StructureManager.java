package me.thebeginning.structures;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.File;
import java.io.FileInputStream;

public class StructureManager {

    public static void pasteStructure(
            Location location,
            String schematicName) {

        try {

            File file = new File(
                    Bukkit.getPluginsFolder()
                    + "/WorldEdit/schematics/"
                    + schematicName
                    + ".schem"
            );

            ClipboardFormat format =
                    ClipboardFormats.findByFile(file);

            if (format == null) {
                return;
            }

            ClipboardReader reader =
                    format.getReader(
                            new FileInputStream(file)
                    );

            Clipboard clipboard =
                    reader.read();

            World world =
                    location.getWorld();

            EditSession editSession =
                    WorldEdit.getInstance()
                            .newEditSession(
                                    BukkitAdapter.adapt(world)
                            );

            Operation operation =
                    new ClipboardHolder(clipboard)
                            .createPaste(editSession)
                            .to(
                                    BlockVector3.at(
                                            location.getBlockX(),
                                            location.getBlockY(),
                                            location.getBlockZ()
                                    )
                            )
                            .ignoreAirBlocks(false)
                            .build();

            Operations.complete(operation);

            editSession.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}