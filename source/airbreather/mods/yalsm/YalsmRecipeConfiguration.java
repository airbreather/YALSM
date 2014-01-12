package airbreather.mods.yalsm;

import java.util.ArrayList;
import airbreather.mods.airbreathercore.item.ItemConfiguration;
import airbreather.mods.airbreathercore.item.ItemDefinition;
import airbreather.mods.airbreathercore.recipe.ShapedCraftingRecipe;
import airbreather.mods.airbreathercore.recipe.Recipe;
import airbreather.mods.airbreathercore.recipe.RecipeConfiguration;
import airbreather.mods.airbreathercore.recipe.RecipeResult;
import airbreather.mods.airbreathercore.recipe.SmeltingRecipe;

// Holds recipe-related configuration information, specific to YALSM.
final class YalsmRecipeConfiguration implements RecipeConfiguration
{
    private boolean enableSimpleRecipe = false;
    private boolean enablePatchworkCraftingRecipe = false;

    private ItemConfiguration itemConfiguration;

    public YalsmRecipeConfiguration(ItemConfiguration itemConfiguration)
    {
        this.itemConfiguration = itemConfiguration;
    }

    public void EnableSimpleSmeltingRecipe()
    {
        this.enableSimpleRecipe = true;
    }

    public void EnablePatchworkCraftingRecipe()
    {
        this.enablePatchworkCraftingRecipe = true;
    }

    public Iterable<Recipe> GetRecipes()
    {
        ArrayList<Recipe> results = new ArrayList<Recipe>(3);

        ItemDefinition rottenFlesh = this.itemConfiguration.GetItemDefinition(YalsmConstants.RottenFleshID);
        ItemDefinition leather = this.itemConfiguration.GetItemDefinition(YalsmConstants.LeatherID);
        ItemDefinition patchwork = this.itemConfiguration.GetItemDefinition(YalsmConstants.PatchworkID);

        RecipeResult patchworkResult = new RecipeResult(patchwork);
        RecipeResult leatherResult = new RecipeResult(leather);

        if (this.enableSimpleRecipe)
        {
            // Smelt Rotten Flesh --> Leather
            // (0.1 experience, same as Cobblestone --> Stone)
            float simpleSmeltingExperience = 0.1f;
            Recipe simpleRecipe = new SmeltingRecipe(leatherResult, rottenFlesh, simpleSmeltingExperience);
            results.add(simpleRecipe);
        }

        if (this.enablePatchworkCraftingRecipe)
        {
            // Craft 5x Rotten Flesh --> 1x Patchwork
            // # . #
            // . # .
            // # . #
            Recipe patchworkCraftingRecipe = new ShapedCraftingRecipe(patchworkResult,
                                                                      "# #",
                                                                      " # ",
                                                                      "# #",
                                                                      '#', rottenFlesh);
            results.add(patchworkCraftingRecipe);
        }

        // Smelt Patchwork --> Leather
        // (0.35 experience, same as Raw Beef --> Steak)
        float patchworkSmeltingExperience = 0.35f;
        Recipe patchworkSmeltingRecipe = new SmeltingRecipe(leatherResult, patchwork, patchworkSmeltingExperience);
        results.add(patchworkSmeltingRecipe);

        results.trimToSize();
        return results;
    }
}
