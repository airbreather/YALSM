YALSM
=====

Yet Another Leather Smelting Mod for Minecraft.

Adds a simple recipe to allow smelting Rotten Flesh to Leather.
It's been done before, I just haven't seen it for 1.6.4.

Tested with Minecraft Forge version 9.11.0.883.

Idea from EpicBlargh's "Rotten Flesh to Leather" mod:
http://www.minecraftforum.net/topic/1487712-151162-rotten-flesh-to-leather-hardcore-version-is-up-to-date

Compiling
---------

I don't like Eclipse, so here's a step-by-step for how to build this by hand.

Dependencies: JDK, JRE.

1. Add JDK\bin and JRE\bin to your PATH.
2. Download the "src" version of Minecraft Forge from http://files.minecraftforge.net (tested with 9.11.0.883).
3. Extract "forge" somewhere, and navigate there.
4. Run "install.cmd" or "install.sh".
6. From this repository, copy the contents of "source" into "mcp/src/minecraft".  Sanity check: there should be a "mcp/src/minecraft/airbreather" folder now.
7. Back in the "forge" directory, run "recompile.bat" or "recompile.sh".
8. When that completes, run "reobfuscate.bat" or "reobfuscate.sh".
9. Navigate to "reobf/minecraft".
10. Zip up everything in here and name the resulting file "yalsm-1.0.0.jar".
11. (mostly optional) Also add the "mcmod.info" and "forge.version" files from this repository to the root of that zip file.
