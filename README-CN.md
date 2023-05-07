# BaimoRconAPI - `Alpha`
[English](https://github.com/Zhou-Shilin/BaimoRconAPI/blob/master/README-CN.md) | Chinese

BaimoRconAPI 是一个 Minecraft 插件，它允许rcon脚本使用命令来获取/修改信息。

## 警告
该插件仍处于 Alpha 阶段，只有少量的 API，其中一些*还没有测试*。**现在不要在生产环境中使用它。**

## 功能
* 获取玩家信息：位置，UUID，世界，生命值，饥饿度，经验，经验等级，允许飞行，速度等。
* 设置玩家信息：显示名称，指南针目标等。
* 正在施工：有关方块和实体的内容。

## TODO
 - [x] 获取/修改玩家信息
 - [ ] 获取/修改方块信息
 - [ ] 获取修改实体NBT
 - [ ] 获取修改物品NBT
 - [ ] 支持添加伪监听器
 - [ ] 支持添加自定义指令

## 安装
1. 从[Releases](https://github.com/Zhou-Shilin/BaimoRconAPI/releases)下载最新版本。
2. 将下载的 `BaimoRconAPI.jar` 文件复制到您的服务器的 `plugins` 文件夹中。
3. 重新启动服务器。

## 用法
点[我](https://baimoqilin.gitbook.io/baimorconapi/documentation)查看完整文档。

### 快速开始

#### 玩家信息
要获取有关玩家的信息，请使用以下命令：
```
/baimoapi player get<信息> <player-name>
```
将 `<信息>` 替换为要获取的信息（例如 `Pos`，`UUID`，`World`，`Health`，`Hunger`，`Exp`，`ExpLevel`，`AllowFlight`，`Speed`，`Locale`，`ClientViewDistance`）。将 `<player-name>` 替换为您要获取信息的玩家的名称。

要修改玩家信息，请使用以下命令：
```
/baimoapi player set<信息> <player-name>
```
将 `<信息>` 替换为要获取的信息（例如 `DisplayName`，`CompassTarget`）。将 `<player-name>` 替换为您要获取信息的玩家的名称。

##### 特殊
要获取玩家的床出生点位置，请使用以下命令：
```
/baimoapi player getBedSpawnLocation <player-name>
```
将 `<player-name>` 替换为您要获取床位置信息的玩家的名称。请注意，如果玩家没有设置床出生点位置，则该命令将返回 "Bed Spawn Location=none"。如果玩家设置了床出生点位置，则该命令将返回世界的名称，然后是床出生点位置的 x、y 和 z 坐标。