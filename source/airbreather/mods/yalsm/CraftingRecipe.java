package airbreather.mods.yalsm;

import net.minecraft.item.ItemStack;
import airbreather.mods.yalsm.Recipe;
import airbreather.mods.yalsm.RecipeType;

// A crafting recipe -- "inputs" come in, ItemStack comes out.
public final class CraftingRecipe extends Recipe
{
    private final ItemStack result;
    private final Object[] inputs;

    // TODO: Figure out how to represent inputs more appropriately.
    // This is how the underlying consumers need it, so meh.
    public CraftingRecipe(ItemStack result, Object... inputs)
    {
        super(RecipeType.Crafting);
        this.result = result;
        this.inputs = inputs;
    }

    public ItemStack GetResult()
    {
        return this.result;
    }

    public Object[] GetInputs()
    {
        return this.inputs;
    }
}
