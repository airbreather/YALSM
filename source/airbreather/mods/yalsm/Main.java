package airbreather.mods.yalsm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
////import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import airbreather.mods.airbreathercore.CustomConfiguration;
import airbreather.mods.airbreathercore.item.FmlItemRegistry;
import airbreather.mods.airbreathercore.item.ItemConfiguration;
import airbreather.mods.airbreathercore.item.ItemRegistry;
import airbreather.mods.airbreathercore.item.ItemRegistrar;
import airbreather.mods.airbreathercore.recipe.FmlRecipeRegistrar;
import airbreather.mods.airbreathercore.recipe.RecipeConfiguration;
import airbreather.mods.airbreathercore.recipe.RecipeRegistrar;

@Mod(modid = YalsmConstants.ModID, name = "Yet Another Leather Smelting Mod", version = YalsmConstants.CurrentVersion)
public final class Main
{
    private final ItemRegistry itemRegistry;
    private final ItemRegistrar itemRegistrar;
    private final RecipeRegistrar recipeRegistrar;
    private final CustomConfiguration configuration;

    public Main()
    {
        this(new FmlItemRegistry(),
             new YalsmItemRegistrar(),
             new FmlRecipeRegistrar(),
             new YalsmConfigurationAdapter());
    }

    public Main(final ItemRegistry itemRegistry, final ItemRegistrar itemRegistrar, final RecipeRegistrar recipeRegistrar, final CustomConfiguration configuration)
    {
        this.itemRegistry = itemRegistry;
        this.itemRegistrar = itemRegistrar;
        this.recipeRegistrar = recipeRegistrar;
        this.configuration = configuration;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        this.configuration.Initialize(event.getSuggestedConfigurationFile());

        ItemConfiguration itemConfiguration = this.configuration.GetItemConfiguration();
        this.itemRegistrar.RegisterNewItems(itemConfiguration, this.itemRegistry);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // This MUST be called during post-initialization, or else FmlItemRegistry won't have any items yet.
        RecipeConfiguration recipeConfiguration = this.configuration.GetRecipeConfiguration();
        this.recipeRegistrar.RegisterRecipes(recipeConfiguration, this.itemRegistry);
    }
}
