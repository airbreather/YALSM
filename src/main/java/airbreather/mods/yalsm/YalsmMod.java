package airbreather.mods.yalsm;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import airbreather.mods.airbreathercore.mod.IModLifecycleManager;
import airbreather.mods.airbreathercore.mod.IModule;
import airbreather.mods.airbreathercore.mod.ModLifecycleManager;

import static com.google.common.base.Preconditions.checkNotNull;

@Mod(modid = YalsmConstants.ModID, name = YalsmConstants.ModName)
public final class YalsmMod
{
    private final IModLifecycleManager modLifecycleManager;

    public YalsmMod(final IModLifecycleManager modLifecycleManager)
    {
        this.modLifecycleManager = checkNotNull(modLifecycleManager, "modLifecycleManager");
    }

    // Either a parameterless constructor or a parameterless static factory
    // method is required for FML to load us.
    @Mod.InstanceFactory
    private static YalsmMod CreateInstance()
    {
        IModule module = new YalsmModule();
        IModLifecycleManager modLifecycleManager = new ModLifecycleManager(module);
        return new YalsmMod(modLifecycleManager);
    }

    @Mod.EventHandler
    private void PreInit(FMLPreInitializationEvent event)
    {
        this.modLifecycleManager.OnPreInit(event);
    }

    @Mod.EventHandler
    private void Init(FMLInitializationEvent event)
    {
        this.modLifecycleManager.OnInit(event);
    }

    @Mod.EventHandler
    private void PostInit(FMLPostInitializationEvent event)
    {
        this.modLifecycleManager.OnPostInit(event);
    }
}
