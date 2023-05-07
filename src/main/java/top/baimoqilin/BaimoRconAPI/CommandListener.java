package top.baimoqilin.BaimoRconAPI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.Container;
import org.bukkit.block.data.BlockData;

import net.minecraft.server.v1_16_R3.NBTBase;
import net.minecraft.server.v1_16_R3.NBTTagCompound;

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
            } else if (args[0].equalsIgnoreCase("block")) {
                if (args[1].equalsIgnoreCase("getID")) {
                    if (args.length == 5) {
                        int x = Integer.parseInt(args[2]);
                        int y = Integer.parseInt(args[3]);
                        int z = Integer.parseInt(args[4]);
                        Block block = Bukkit.getWorld(sender.getName()).getBlockAt(x, y, z);
                        sender.sendMessage("BlockID=" + block.getType().name());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=01, Invalid subcommand usage.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getNBTAll")) {
                    if (args.length == 5) {
                        int x = Integer.parseInt(args[2]);
                        int y = Integer.parseInt(args[3]);
                        int z = Integer.parseInt(args[4]);
                        Block block = Bukkit.getWorld(sender.getName()).getBlockAt(x, y, z);
                        BlockState state = block.getState();
                        NBTTagCompound nbt = new NBTTagCompound();
                        if (state instanceof Container) {
                            Container container = (Container)state;
                            nbt = container.getTileEntity().save(nbt);
                        } else {
                            nbt = state.getBlockData().save(nbt);
                        }
                        sender.sendMessage("NBT=" + nbt.toString());
                        return true;
                    } else {
                        sender.sendMessage("ERROR=01, Invalid subcommand usage.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("getNBT")) {
                    if (args.length == 6) {
                        int x = Integer.parseInt(args[2]);
                        int y = Integer.parseInt(args[3]);
                        int z = Integer.parseInt(args[4]);
                        Block block = Bukkit.getWorld(sender.getName()).getBlockAt(x, y, z);
                        BlockState state = block.getState();
                        NBTBase value = null;
                        if (state instanceof Container) {
                            Container container = (Container)state;
                            NBTTagCompound nbt = container.getTileEntity().save(new NBTTagCompound());
                            String[] keys = args[5].split("\\.");
                            for (String key : keys) {
                                value = nbt.get(key);
                                if (value instanceof NBTTagCompound) {
                                    nbt = (NBTTagCompound)value;
                                }
                            }
                        } else {
                            BlockData data = state.getBlockData();
                            for (String key : args[5].split("\\.")) {
                                value = data.getNBTData().get(key);
                                if (value instanceof NBTTagCompound) {
                                    data = Material.STONE.createBlockData();
                                    data.setNBTData((NBTTagCompound)value);
                                }
                            }
                        }
                        if (value != null) {
                            sender.sendMessage("NBT=" + value.toString());
                        } else {
                            sender.sendMessage("ERROR=03, NBT not found.");
                        }
                        return true;
                    } else {
                        sender.sendMessage("ERROR=01, Invalid subcommand usage.");
                        return false;
                    }
                } else if (args[1].equalsIgnoreCase("setNBT")) {
                    if (args.length == 7) {
                        int x = Integer.parseInt(args[2]);
                        int y = Integer.parseInt(args[3]);
                        int z = Integer.parseInt(args[4]);
                        Block block = Bukkit.getWorld(sender.getName()).getBlockAt(x, y, z);
                        BlockState state = block.getState();
                        String[] keys = args[5].split("\\.");
                        NBTBase value = null;
                        if (state instanceof Container) {
                            Container container = (Container)state;
                            NBTTagCompound nbt = container.getTileEntity().save(new NBTTagCompound());
                            for (int i = 0; i < keys.length - 1; i++) {
                                String key = keys[i];
                                if (!nbt.hasKey(key)) {
                                    nbt.set(key, new NBTTagCompound());
                                }
                                value = nbt.get(key);
                                if (value instanceof NBTTagCompound) {
                                    nbt = (NBTTagCompound)value;
                                } else {
                                    sender.sendMessage("ERROR=04, Invalid NBT path.");
                                    return false;
                                }
                            }
                            String key = keys[keys.length - 1];
                            NBTTagCompound newValue = NBTUtils.parseTag(args[6]);
                            nbt.set(key, newValue);
                            container.getTileEntity().load(nbt);
                        } else {
                            BlockData data = state.getBlockData();
                            for (String key : keys) {
                                value = data.getNBTData().get(key);
                                if (value instanceof NBTTagCompound) {
                                    data = Material.STONE.createBlockData();
                                    data.setNBTData((NBTTagCompound)value);
                                } else {
                                    sender.sendMessage("ERROR=04, Invalid NBT path.");
                                    return false;
                                }
                            }
                            NBTTagCompound nbt = NBTUtils.parseTag(args[6]);
                            data.setNBTData(nbt);
                            state.setBlockData(data);
                            state.update(true);
                        }
                        sender.sendMessage("msg=Success");
                        return true;
                    } else {
                        sender.sendMessage("ERROR=01, Invalid subcommand usage .");
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