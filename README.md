# BaimoRconAPI - `Alpha`
![Logo](https://cdn.staticaly.com/gh/Zhou-Shilin/picx-images-hosting@master/20230410/3A613F7A-B745-4A88-A68D-F83F9799C3CB.4ckvtiuzkrls.webp)
English | [Chinese](https://github.com/Zhou-Shilin/BaimoRconAPI/blob/master/README-CN.md)  
[![Hits](https://hits.sh/github.com/Zhou-Shilin/BaimoRconAPI.svg)](https://hits.sh/github.com/Zhou-Shilin/BaimoRconAPI/)

BaimoRconAPI is a Minecraft plugin that allows rcon scripts to use commands to get info and control the server. 

## Warning
The plugin is still in Alpha, there's only a few APIs and some of them are *Untested*. **Do not use it in production environment now.**

## Features
* Get player information: position, UUID, world, health, hunger, experience, experience level, allow flight, speed, etc.
* Set player information: display name, compass target, etc.
* In development: about block and entity, etc.

## TODO
 - [x] Get/Modify player information
 - [x] Get/Modify block information
 - [ ] Get/Modify entity
 - [ ] Get/Modify item
 - [ ] Support for adding pseudo-listeners
 - [ ] Support for adding custom commands

## Installation
1. Download the latest release from the [releases page](https://github.com/Zhou-Shilin/BaimoRconAPI/releases).
2. Copy the downloaded `BaimoRconAPI.jar` file into your server's `plugins` folder.
3. Restart the server.

## Usage
Please visit [me](https://baimoqilin.gitbook.io/baimorconapi/documentation) for the full documentation.

### Quick Start

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

