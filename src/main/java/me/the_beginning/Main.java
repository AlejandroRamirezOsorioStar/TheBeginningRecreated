package me.thebeginning;

import me.thebeginning.ytic.YticManager;
import me.thebeginning.portal.BeginningPortalManager;
import me.thebeginning.commands.BeginningCommand;
import me.thebeginning.world.BeginningGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        getLogger().info(
                "The Beginning Recreated enabled."
        );

        BeginningGenerator.createWorld();
        BeginningPortalManager.generatePortal();
        YticManager.generateYtic();

        getCommand("thebeginning")
                .setExecutor(
                        new BeginningCommand()
                );
    }

    @Override
    public void onDisable() {

        getLogger().info(
                "The Beginning Recreated disabled."
        );
    }

    public static Main getInstance() {
        return instance;
    }
}