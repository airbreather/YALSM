package airbreather.mods.yalsm;

import com.google.common.collect.ImmutableList;

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
        ImmutableList.Builder<Recipe> resultBuilder = ImmutableList.builder();

        ItemDefinition rottenFlesh = YalsmConstants.RottenFleshItemDefinition;
        ItemDefinition leather = YalsmConstants.LeatherItemDefinition;
        ItemDefinition patchwork = YalsmConstants.PatchworkItemDefinition;

        RecipeResult patchworkResult = new RecipeResult(patchwork);
        RecipeResult leatherResult = new RecipeResult(leather);

        if (this.enableSimpleRecipe)
        {
            // Smelt Rotten Flesh --> Leather
            // (0.1 experience, same as Cobblestone --> Stone)
            float simpleSmeltingExperience = 0.1f;
            Recipe simpleRecipe = new SmeltingRecipe(leatherResult, rottenFlesh, simpleSmeltingExperience);
            resultBuilder.add(simpleRecipe);
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
            resultBuilder.add(patchworkCraftingRecipe);
        }

        // Smelt Patchwork --> Leather
        // (0.35 experience, same as Raw Beef --> Steak)
        // If you have Patchwork, then you can smelt it, even if you can't create it anymore.
        float patchworkSmeltingExperience = 0.35f;
        Recipe patchworkSmeltingRecipe = new SmeltingRecipe(leatherResult, patchwork, patchworkSmeltingExperience);
        resultBuilder.add(patchworkSmeltingRecipe);

        return resultBuilder.build();
    }
}
