YALSM
=====

Yet Another Leather Smelting Mod for Minecraft.

Adds a simple recipe to allow smelting Rotten Flesh to Leather.
It's been done before, I just haven't seen it for 1.6.4.

Tested with Minecraft Forge version 9.11.1.953.

Idea from EpicBlargh's "Rotten Flesh to Leather" mod:
http://www.minecraftforum.net/topic/1487712-151162-rotten-flesh-to-leather-hardcore-version-is-up-to-date

Compiling
---------

I don't like Eclipse, so here's a step-by-step for how to build this by hand.

Dependencies: JDK, JRE.

1. Add JDK\bin and JRE\bin to your PATH.
2. Download the "src" version of Minecraft Forge from http://files.minecraftforge.net (tested with 9.11.1.953).
3. Extract "forge" somewhere, and navigate there.
4. Run "install.cmd" or "install.sh".
5. Navigate to the "mcp" directory.
6. From this repository, copy the contents of "source" into "src/minecraft".  Sanity check: there should be a "src/minecraft/airbreather/mods/yalsm" folder now.
7. From this repository, copy the contents of "modules/airbreathercore/source" into "src/minecraft".  Sanity check: there should be a "src/minecraft/airbreather/mods/airbreathercore" folder now.
8. Run "recompile.bat" or "recompile.sh".
9. When that completes, run "reobfuscate.bat" or "reobfuscate.sh".
10. Navigate to the "reobf/minecraft" directory.
11. From this repository, copy the "assets" folder to this folder.  Sanity check: starting from the "mcp" directory, there should be a "reobf/minecraft/assets/yalsm" directory now.
12. Zip up everything in here and name the resulting file "yalsm-2.0.2.jar".
13. Optionally, also add to that zip file the loose files provided in the root of this repository (excluding git-related hidden files and this README.md).
