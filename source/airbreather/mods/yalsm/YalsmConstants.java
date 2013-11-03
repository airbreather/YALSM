package airbreather.mods.yalsm;

// Some constants used throughout the mod.
final class YalsmConstants
{
    // ID of the mod.
    public static final String ModID = "YALSM";

    // Current version of the mod.
    public static final String CurrentVersion = "2.0.1";

    // An ID that refers to the patchwork item.
    // NOT the actual configurable item ID, just something to use internally.
    public static final int PatchworkID = 0;

    // The string that refers to the texture file for the patchwork item's icon.
    // Ends up being "YALSM:patchwork", which translates to assets/yalsm/textures/items/patchwork.png
    public static final String PatchworkTextureID = ModID + ":patchwork";

    // The English name for the patchwork item.
    // TODO: globalize... that's a project for another day.
    public static final String PatchworkEnglishName = "Patchwork Flesh";
}
