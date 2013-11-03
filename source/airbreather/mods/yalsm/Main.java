package airbreather.mods.yalsm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import airbreather.mods.airbreathercore.CustomConfiguration;
import airbreather.mods.airbreathercore.recipe.FmlRecipeRegistrar;
import airbreather.mods.airbreathercore.recipe.RecipeConfiguration;
import airbreather.mods.airbreathercore.recipe.RecipeRegistrar;

// Lots of this is boilerplate from the Forge tutorial -- not sure how much I can just delete.
@Mod(modid = YalsmConstants.ModID, name = "Yet Another Leather Smelting Mod", version = YalsmConstants.CurrentVersion)
@NetworkMod(clientSideRequired = true)
public final class Main
{
    private final RecipeRegistrar recipeRegistrar;
    private final CustomConfiguration configuration;

    public Main()
    {
        this(new FmlRecipeRegistrar(),
             new YalsmConfigurationAdapter());
    }

    public Main(final RecipeRegistrar recipeRegistrar, final CustomConfiguration configuration)
    {
        this.recipeRegistrar = recipeRegistrar;
        this.configuration = configuration;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        this.configuration.Initialize(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        RecipeConfiguration recipeConfiguration = this.configuration.GetRecipeConfiguration();
        this.recipeRegistrar.RegisterRecipes(recipeConfiguration.GetRecipes());
    }
}
