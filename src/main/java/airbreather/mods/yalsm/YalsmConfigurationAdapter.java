package airbreather.mods.yalsm;

import java.io.File;
import static com.google.common.base.Preconditions.checkNotNull;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import airbreather.mods.airbreathercore.CustomConfigurationBase;
import airbreather.mods.airbreathercore.item.ItemConfiguration;
import airbreather.mods.airbreathercore.recipe.RecipeConfiguration;

// Implements CustomConfiguration using the standard Forge configuration pattern, given a File.
final class YalsmConfigurationAdapter extends CustomConfigurationBase
{
    private final YalsmItemConfiguration itemConfiguration;
    private final YalsmRecipeConfiguration recipeConfiguration;

    public YalsmConfigurationAdapter(YalsmItemConfiguration itemConfiguration,
                                     YalsmRecipeConfiguration recipeConfiguration)
    {
        this.itemConfiguration = checkNotNull(itemConfiguration, "itemConfiguration");
        this.recipeConfiguration = checkNotNull(recipeConfiguration, "recipeConfiguration");
    }

    @Override
    public void Initialize(File configurationFile)
    {
        Configuration forgeConfiguration = new Configuration(configurationFile);
        forgeConfiguration.load();

        if (ShouldEnableSimpleRecipe(forgeConfiguration))
        {
            this.recipeConfiguration.EnableSimpleSmeltingRecipe();
        }

        if (ShouldEnablePatchworkCraftingRecipe(forgeConfiguration))
        {
            this.recipeConfiguration.EnablePatchworkCraftingRecipe();
        }

        // TODO: Skip saving if we aren't in "create-initial" mode.
        forgeConfiguration.save();
    }

    @Override
    public RecipeConfiguration GetRecipeConfiguration()
    {
        return this.recipeConfiguration;
    }

    @Override
    public ItemConfiguration GetItemConfiguration()
    {
        return this.itemConfiguration;
    }

    private static boolean ShouldEnableSimpleRecipe(Configuration forgeConfiguration)
    {
        final boolean enableSimpleRecipeDefault = false;
        final String enableSimpleRecipeName = "enableSimpleRecipe";
        final String enableSimpleRecipeComment = "Enable the Rotten Flesh --> Leather smelting recipe?  true/false (false is the default)";

        Property enableSimpleRecipeProperty = forgeConfiguration.get(Configuration.CATEGORY_GENERAL, enableSimpleRecipeName, enableSimpleRecipeDefault, enableSimpleRecipeComment);
        return enableSimpleRecipeProperty.getBoolean(enableSimpleRecipeDefault);
    }

    private static boolean ShouldEnablePatchworkCraftingRecipe(Configuration forgeConfiguration)
    {
        // Not really any point in making this configurable,
        // especially considering that we should register the item anyway.
        ////String enablePatchworkRecipePropertyName = "enablePatchworkCraftingRecipe";
        ////boolean enablePatchworkRecipeDefault = true;
        ////String enablePatchworkRecipeComment = "Enable the Patchwork Flesh crafting recipe?  true/false (true is the default)" +
        ////                                      Configuration.NEW_LINE +
        ////                                      "Patchwork Flesh is crafted by 5 Rotten Flesh in an X pattern, and can be smelted into Leather.";
        ////
        ////Property enablePatchworkRecipeProperty = forgeConfiguration.get(Configuration.CATEGORY_GENERAL, enablePatchworkRecipePropertyName, enablePatchworkRecipeDefault, enablePatchworkRecipeComment);
        ////return enablePatchworkRecipeProperty.getBoolean(enablePatchworkRecipeDefault);
        return true;
    }
}
