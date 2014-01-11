package airbreather.mods.yalsm;

import airbreather.mods.airbreathercore.item.ItemDefinition;

// Some constants used throughout the mod.
final class YalsmConstants
{
    // ID of the mod.
    public static final String ModID = "YALSM";

    // ID of the base game.
    public static final String BaseGameModID = "minecraft";

    // Name of the mod.
    public static final String ModName = "Yet Another Leather Smelting Mod";

    // Refers to the rotten flesh item in the base game.
    public static final ItemDefinition RottenFleshItemDefinition = new ItemDefinition(BaseGameModID, "rotten_flesh");

    // Refers to the leather item in the base game.
    public static final ItemDefinition LeatherItemDefinition = new ItemDefinition(BaseGameModID, "leather");

    // Refers to the patchwork item added by this mod.
    public static final ItemDefinition PatchworkItemDefinition = new ItemDefinition(ModID, "patchworkFlesh");
}
