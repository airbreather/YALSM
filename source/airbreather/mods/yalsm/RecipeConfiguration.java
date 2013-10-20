package airbreather.mods.yalsm;

import airbreather.mods.yalsm.Recipe;

// An interface for a configuration that holds Recipes configured for this mod.
public interface RecipeConfiguration
{
    // Gets the Recipes configured for this mod.
    Iterable<Recipe> GetRecipes();
}
