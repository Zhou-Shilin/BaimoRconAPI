package top.baimoqilin.BaimoRconAPI;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Main extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("baimoapi").setExecutor(this);
        getLogger().info("BaimoRconAPI enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("BaimoRconAPI disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("baimoapi")) {
            if (args.length < 3) {
                sender.sendMessage(ChatColor.RED + "Invalid command usage. Usage: /baimoapi player <getPos/getUuid/getWorld/getBlood/getHunger> <player-name>");
                return false;
            }
            if (args[0].equalsIgnoreCase("player")) {
                if (args[1].equalsIgnoreCase("getPos")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        Location loc = target.getLocation();
                        sender.sendMessage("x=" + loc.getBlockX() + ", y=" + loc.getBlockY() + ", z=" + loc.getBlockZ());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getUuid")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("UUID=" + target.getUniqueId());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getWorld")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("World=" + target.getWorld().getName());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getHealth")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        double healthValue = target.getHealth();
                        sender.sendMessage("Blood=" + healthValue);
                        return true;
                    } else {
                        sender.sendMessage("ERROR=Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getHunger")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("Hunger=" + target.getFoodLevel());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=Player not found.");
                        return false;
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "ERROR=Invalid subcommand.");
                    return false;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "ERROR=Invalid command.");
                return false;
            }
        }
        return false;
     }
}