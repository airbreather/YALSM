package airbreather.mods.yalsm;

import java.io.File;

// Interface for mod configurations.
public interface CustomConfiguration
{
    // Initializes the configuration from a file.
    // TODO: If I ever care enough to write unit tests, make this mockable.
    void Initialize(File configurationFile);

    // Gets the ItemConfiguration object that maps arbitrary internal IDs to Item objects that this mod uses.
    ItemConfiguration GetItemConfiguration();

    // Gets the RecipeConfiguration object that is used to fetch the recipes configured for this mod.
    RecipeConfiguration GetRecipeConfiguration();
}
