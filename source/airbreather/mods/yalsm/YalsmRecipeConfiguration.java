package airbreather.mods.yalsm;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import airbreather.mods.yalsm.ItemConfiguration;
import airbreather.mods.yalsm.Recipe;
import airbreather.mods.yalsm.SmeltingRecipe;
import airbreather.mods.yalsm.CraftingRecipe;

// Holds recipe-related configuration information, specific to YALSM.
final class YalsmRecipeConfiguration implements RecipeConfiguration
{
    private boolean enableSimpleRecipe = false;
    private boolean enablePatchworkRecipes = false;

    private ItemConfiguration itemConfiguration;

    public YalsmRecipeConfiguration(ItemConfiguration itemConfiguration)
    {
        this.itemConfiguration = itemConfiguration;
    }

    public void EnableSimpleSmeltingRecipe()
    {
        this.enableSimpleRecipe = true;
    }

    public void EnablePatchworkRecipes()
    {
        this.enablePatchworkRecipes = true;
    }

    public Iterable<Recipe> GetRecipes()
    {
        ArrayList<Recipe> results = new ArrayList<Recipe>(3);

        Item rottenFleshItem = Item.rottenFlesh;
        Item patchworkItem = this.itemConfiguration.GetItem(YalsmConstants.PatchworkID);
        ItemStack leatherResult = new ItemStack(Item.leather);
        ItemStack patchworkResult = new ItemStack(patchworkItem);

        if (this.enableSimpleRecipe)
        {
            // Smelt Rotten Flesh --> Leather
            // (0.1 experience, same as Cobblestone --> Stone)
            float simpleSmeltingExperience = 0.1f;
            Recipe simpleRecipe = new SmeltingRecipe(leatherResult, rottenFleshItem, simpleSmeltingExperience);
            results.add(simpleRecipe);
        }

        if (this.enablePatchworkRecipes)
        {
            // Craft 5x Rotten Flesh --> 1x Patchwork
            // # . #
            // . # .
            // # . #
            Recipe patchworkCraftingRecipe = new CraftingRecipe(patchworkResult,
                                                                "# #",
                                                                " # ",
                                                                "# #",
                                                                '#', rottenFleshItem);
            results.add(patchworkCraftingRecipe);

            // Smelt Patchwork --> Leather
            // (0.35 experience, same as Raw Beef --> Steak)
            float patchworkSmeltingExperience = 0.35f;
            Recipe patchworkSmeltingRecipe = new SmeltingRecipe(leatherResult, patchworkItem, patchworkSmeltingExperience);
            results.add(patchworkSmeltingRecipe);
        }

        results.trimToSize();
        return results;
    }
}
