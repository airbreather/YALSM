package airbreather.mods.yalsm;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import airbreather.mods.airbreathercore.CustomConfigurationBase;
import airbreather.mods.airbreathercore.item.ItemConfiguration;
import airbreather.mods.airbreathercore.event.EventConfiguration;
import airbreather.mods.airbreathercore.recipe.RecipeConfiguration;

// Implements CustomConfiguration using the standard Forge configuration pattern, given a File.
final class YalsmConfigurationAdapter extends CustomConfigurationBase
{
    private final YalsmItemConfiguration itemConfiguration = new YalsmItemConfiguration();
    private final YalsmRecipeConfiguration recipeConfiguration = new YalsmRecipeConfiguration(this.itemConfiguration);

    @Override
    public void Initialize(File configurationFile)
    {
        Configuration forgeConfiguration = new Configuration(configurationFile);
        forgeConfiguration.load();

        if (ShouldEnableSimpleRecipe(forgeConfiguration))
        {
            this.recipeConfiguration.EnableSimpleSmeltingRecipe();
        }

        if (ShouldEnablePatchworkRecipes(forgeConfiguration))
        {
            // Need to call this AFTER setting the item in the ItemConfiguration.
            this.recipeConfiguration.EnablePatchworkRecipes();
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
        boolean enableSimpleRecipeDefault = false;
        String enableSimpleRecipeName = "enableSimpleRecipe";
        String enableSimpleRecipeComment = "Enable the Rotten Flesh --> Leather smelting recipe?  true/false (false is the default)";

        Property enableSimpleRecipeProperty = forgeConfiguration.get(Configuration.CATEGORY_GENERAL, enableSimpleRecipeName, enableSimpleRecipeDefault, enableSimpleRecipeComment);
        return enableSimpleRecipeProperty.getBoolean(enableSimpleRecipeDefault);
    }

    private static boolean ShouldEnablePatchworkRecipes(Configuration forgeConfiguration)
    {
        // Not really any point in making this configurable,
        // especially considering that we should register the item anyway.
        ////String enablePatchworkRecipePropertyName = "enablePatchworkRecipes";
        ////boolean enablePatchworkRecipeDefault = true;
        ////String enablePatchworkRecipeComment = "Enable the Patchwork Flesh crafting recipe and the Patchwork Flesh --> Leather smelting recipe?  true/false (true is the default)" +
        ////                                      Configuration.NEW_LINE +
        ////                                      "Patchwork Flesh is crafted by 5 Rotten Flesh in an X pattern.";
        ////
        ////Property enablePatchworkRecipeProperty = forgeConfiguration.get(Configuration.CATEGORY_GENERAL, enablePatchworkRecipePropertyName, enablePatchworkRecipeDefault, enablePatchworkRecipeComment);
        ////return enablePatchworkRecipeProperty.getBoolean(enablePatchworkRecipeDefault);
        return true;
    }
}
