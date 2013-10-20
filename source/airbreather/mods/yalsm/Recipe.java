package airbreather.mods.yalsm;

import airbreather.mods.yalsm.RecipeType;

// Base class for all recipes that can be registered using the RecipeRegistrar.
// The RecipeType indicates what kind of a recipe this is (Crafting / Smelting).
public abstract class Recipe
{
    private final RecipeType recipeType;

    protected Recipe(RecipeType recipeType)
    {
        this.recipeType = recipeType;
    }

    public RecipeType GetRecipeType()
    {
        return this.recipeType;
    }
}