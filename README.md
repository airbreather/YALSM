YALSM
=====

Yet Another Leather Smelting Mod for Minecraft.

Adds a simple recipe to allow smelting Rotten Flesh to Leather.
It's been done before, but never updated enough for me.

Tested with Minecraft Forge version 10.12.0.971.

Idea from EpicBlargh's "Rotten Flesh to Leather" mod:
http://www.minecraftforum.net/topic/1487712-151162-rotten-flesh-to-leather-hardcore-version-is-up-to-date

Compiling
---------

I don't like Eclipse, so here's a step-by-step for how to build this by hand.

Dependencies: JDK, JRE, Gradle (tested with 1.10).

Once
----
1. Set the GRADLE_HOME environment variable to wherever you installed Gradle (the folder that contains bin, init.d, lib, etc.).
2. Add JDK\bin, JRE\bin, and GRADLE_HOME\bin to your PATH.

Every time
----------
1. Navigate to the YALSM source tree.
2. Run "gradle build".
3. The result will be in the "build\libs".
