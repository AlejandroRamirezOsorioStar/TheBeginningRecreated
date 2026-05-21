package me.thebeginning.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BeginningCommand implements CommandExecutor {

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        World world =
                Bukkit.getWorld("the_beginning");

        if (world == null) {

            player.sendMessage(
                    "§cThe Beginning no existe."
            );

            return true;
        }

        player.teleport(
                new Location(world, 0, 120, 0)
        );

        player.sendMessage(
                "§5Entraste a The Beginning."
        );

        return true;
    }
}