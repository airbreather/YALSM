package airbreather.mods.yalsm;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import airbreather.mods.yalsm.Recipe;
import airbreather.mods.yalsm.CraftingRecipe;
import airbreather.mods.yalsm.SmeltingRecipe;

// A RecipeRegistrar that registers the given recipes using the FML GameRegistry.
final class YalsmRecipeRegistrar implements RecipeRegistrar
{
    // register the recipes for this mod.
    public void RegisterRecipes(Iterable<Recipe> recipes)
    {
        for (Recipe recipe : recipes)
        {
            switch (recipe.GetRecipeType())
            {
                case Smelting:
                    this.RegisterSmeltingRecipe(recipe);
                    break;

                case Crafting:
                    this.RegisterCraftingRecipe(recipe);
                    break;
            }
        }
    }

    private void RegisterSmeltingRecipe(Recipe recipe)
    {
        SmeltingRecipe smeltingRecipe = (SmeltingRecipe)recipe;

        int inputID = smeltingRecipe.GetInput().itemID;
        ItemStack result = smeltingRecipe.GetResult();
        float experience = smeltingRecipe.GetExperience();

        GameRegistry.addSmelting(inputID, result, experience);
    }

    private void RegisterCraftingRecipe(Recipe recipe)
    {
        CraftingRecipe craftingRecipe = (CraftingRecipe)recipe;

        ItemStack result = craftingRecipe.GetResult();
        Object[] inputs = craftingRecipe.GetInputs();

        GameRegistry.addRecipe(result, inputs);
    }
}
