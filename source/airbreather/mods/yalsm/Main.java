package airbreather.mods.yalsm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import airbreather.mods.yalsm.RecipeRegistrar;
import airbreather.mods.yalsm.YalsmConstants;
import airbreather.mods.yalsm.YalsmRecipeRegistrar;

// Lots of this is boilerplate from the Forge tutorial -- not sure how much I can just delete.
@Mod(modid = YalsmConstants.ModID, name = "Yet Another Leather Smelting Mod", version = YalsmConstants.CurrentVersion)
@NetworkMod(clientSideRequired = true)
public final class Main
{
    @Instance(value = YalsmConstants.ModID)
    public static Main instance;

    @SidedProxy(clientSide = "airbreather.mods.yalsm.client.ClientProxy",
                serverSide = "airbreather.mods.yalsm.CommonProxy")
    public static CommonProxy proxy;

    private final RecipeRegistrar recipeRegistrar;
    private final CustomConfiguration configuration;

    public Main()
    {
        this(new YalsmRecipeRegistrar(),
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
        proxy.registerRenderers();

        RecipeConfiguration recipeConfiguration = this.configuration.GetRecipeConfiguration();
        this.recipeRegistrar.RegisterRecipes(recipeConfiguration.GetRecipes());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
