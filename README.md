# BaimoRconAPI - `Alpha`
English | (Chinese)[https://github.com/Zhou-Shilin/BaimoRconAPI/blob/master/README-CN.md]

BaimoRconAPI is a Minecraft plugin that allows rcon scripts to use commands to get info and control the server. This API is exposed via a simple command interface that can be accessed from the in-game console or from a remote client.

## Warning
The plugin is still in Alpha, there's only a few APIs and some of them are *Untested*. **Do not use it in production environment now.**

## Features
* Get player information: position, UUID, world, health, hunger, experience, experience level, allow flight, speed, etc.
* Set player information: display name, compass target, etc.
* In development: about block and entity, etc.

## Installation
1. Download the latest release from the [releases page](https://github.com/Zhou-Shilin/BaimoRconAPI/releases).
2. Copy the downloaded `BaimoRconAPI.jar` file into your server's `plugins` folder.
3. Restart the server.

## Usage
To use BaimoRconAPI, you must have permission to execute the `baimoapi` command. By default, only players with the `op` or `baimoapi.use` permission node can execute this command.

### API Commands

#### Player Information
To get information on a player, use the following command:
```
/baimoapi player get<Info> <player-name>
```
Replace `<Info>` with the information you want to get (e.g. `Pos`, `UUID`, `World`, `Health`, `Hunger`, `Exp`, `ExpLevel`, `AllowFlight`, `Speed`, `Locale`, `ClientViewDistance`). Replace `<player-name>` with the name of the player you want to get information on.

To modify information on a player, use the following command:
```
/baimoapi player set<Info> <player-name>
```
Replace `<Info>` with the information you want to get (e.g. `DisplayName`, `CompassTarget`). Replace `<player-name>` with the name of the player you want to get information on.


##### Special
To get a player's bed spawn location, use the following command:
```
/baimoapi player getBedSpawnLocation <player-name>
```
Replace `<player-name>` with the name of the player whose bed spawn location you want to get. Note that if the player has not set a bed spawn location, the command will return "Bed Spawn Location=none". If the player has set a bed spawn location, the command will return the name of the world, followed by the x, y, and z coordinates of the bed spawn location.