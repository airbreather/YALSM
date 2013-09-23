package airbreather.mods.yalsm;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

// A RecipeRegistrar that registers the simple smelting recipe.
final class YalsmRecipeRegistrar implements RecipeRegistrar
{
    // register the recipes for this mod.
    public void RegisterRecipes()
    {
        this.RegisterSmeltingRecipes();
    }
    
    private void RegisterSmeltingRecipes()
    {
        ItemStack leatherResult = new ItemStack(Item.leather);
        int rottenFleshId = Item.rottenFlesh.itemID;
        float leatherSmeltingExperience = 0.1f;
        
        // Rotten Flesh --> Leather, 0.1 experience (minimum allowed).
        GameRegistry.addSmelting(rottenFleshId, leatherResult, leatherSmeltingExperience);
    }
}
