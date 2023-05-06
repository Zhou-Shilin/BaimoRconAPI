package top.baimoqilin.BaimoRconAPI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class CommandListener implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("baimoapi")) {
            if (args.length < 3) {
                sender.sendMessage("ERROR=01, Invalid command.");
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
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getUuid")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("UUID=" + target.getUniqueId());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getWorld")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("World=" + target.getWorld().getName());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getHealth")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        double healthValue = target.getHealth();
                        sender.sendMessage("Blood=" + healthValue);
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getHunger")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("Hunger=" + target.getFoodLevel());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getExp")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("Experience=" + target.getExp());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getExpLevel")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("Experience Level=" + target.getLevel());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getAllowFlight")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("Allow Flight=" + target.getAllowFlight());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getSpeed")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        if (args.length == 3 || args[3].equalsIgnoreCase("walk")) {
                            sender.sendMessage("Walk Speed=" + target.getWalkSpeed());
                        } else if (args[3].equalsIgnoreCase("fly")) {
                            sender.sendMessage("Fly Speed=" + target.getFlySpeed());
                        } else {
                            sender.sendMessage("ERROR=01, Invalid subcommand.");
                            return false;
                        }
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("setDisplayName")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        String displayName = args[3];
                        target.setDisplayName(displayName);
                        sender.sendMessage("msg=Success");
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("setCompassTarget")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        int x = Integer.parseInt(args[3]);
                        int y = Integer.parseInt(args[4]);
                        int z = Integer.parseInt(args[5]);
                        Location targetLocation = new Location(target.getWorld(), x, y, z);
                        target.setCompassTarget(targetLocation);
                        sender.sendMessage("msg=Success");
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getLocale")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("Locale=" + target.getLocale());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getClientViewDistance")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        sender.sendMessage("Client View Distance=" + target.getClientViewDistance());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getBedSpawnLocation")) {
                    Player target = Bukkit.getPlayer(args[2]);
                    if (target != null) {
                        Location bedSpawnLocation = target.getBedSpawnLocation();
                        if ( bedSpawnLocation != null ) {
                            sender.sendMessage("Bed Spawn Location=" + bedSpawnLocation.getWorld().getName() + "," + bedSpawnLocation.getX() + "," + bedSpawnLocation.getY() + "," + bedSpawnLocation.getZ());
                        } else {
                            sender.sendMessage("Bed Spawn Location=none");
                        }
                        return true;
                    } else {
                        sender.sendMessage("ERROR=02, Player not found.");
                        return false;
                    }
                } else {
                    sender.sendMessage("ERROR=01, Invalid subcommand.");
                    return false;
                }
            } else {
                sender.sendMessage("ERROR=01, Invalid command.");
                return false;
            }
        }
        return false;
    }
}
