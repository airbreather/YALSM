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
import airbreather.mods.yalsm.YalsmRecipeRegistrar;

// Lots of this is boilerplate from the Forge tutorial -- not sure how much I can just delete.
@Mod(modid="YALSM", name="Yet Another Leather Smelting Mod", version="1.0.0")
@NetworkMod(clientSideRequired=true)
public final class Main
{
    @Instance(value = "YALSM")
    public static Main instance;
    
    @SidedProxy(clientSide="airbreather.mods.yalsm.client.ClientProxy",
                serverSide="airbreather.mods.yalsm.CommonProxy")
    public static CommonProxy proxy;
				
				private final RecipeRegistrar recipeRegistrar;
    
				public Main()
				{
				    this(new YalsmRecipeRegistrar());
				}
				
				public Main(final RecipeRegistrar recipeRegistrar)
				{
				    this.recipeRegistrar = recipeRegistrar;
				}
				
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        proxy.registerRenderers();
								
								this.recipeRegistrar.RegisterRecipes();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
