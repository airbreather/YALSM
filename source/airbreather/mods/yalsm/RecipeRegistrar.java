package airbreather.mods.yalsm;

import airbreather.mods.yalsm.Recipe;

// An interface for something that registers recipes.
public interface RecipeRegistrar
{
    // register the recipes.
    void RegisterRecipes(Iterable<Recipe> recipes);
}
