package airbreather.mods.yalsm;

// Some constants used throughout the mod.
final class YalsmConstants
{
    // ID of the mod.
    public static final String ModID = "YALSM";

    // ID of the base game.
    public static final String BaseGameModID = "Minecraft";

    // Current version of the mod.
    public static final String CurrentVersion = "2.0.2";

    // An ID that refers to the patchwork item.
    // NOT the actual configurable item ID, just something to use internally.
    public static final int PatchworkID;

    // An ID that refers to the rotten flesh item.
    // NOT the actual item ID, just something to use internally.
    public static final int RottenFleshID;

    // An ID that refers to the leather item.
    // NOT the actual item ID, just something to use internally.
    public static final int LeatherID;

    // The name of the patchwork item.
    public static final String PatchworkItemName = "patchworkFlesh";

    // The name of the rotten flesh item.
    public static final String RottenFleshItemName = "rottenFlesh";

    // The name of the leather item.
    public static final String LeatherItemName = "leather";

    static
    {
        int x = 0;
        PatchworkID = x++;
        RottenFleshID = x++;
        LeatherID = x++;
    }
}
