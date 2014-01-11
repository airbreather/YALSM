package airbreather.mods.yalsm;

import airbreather.mods.airbreathercore.CustomConfiguration;
import airbreather.mods.airbreathercore.item.ItemRegistrar;
import airbreather.mods.airbreathercore.mod.ModuleBase;

final class YalsmModule extends ModuleBase
{
    private final CustomConfiguration customConfiguration;

    public YalsmModule()
    {
        super();

        YalsmItemConfiguration itemConfiguration = new YalsmItemConfiguration();
        YalsmRecipeConfiguration recipeConfiguration = new YalsmRecipeConfiguration();

        this.customConfiguration = new YalsmConfigurationAdapter(itemConfiguration,
                                                                 recipeConfiguration);
    }

    @Override
    public ItemRegistrar GetItemRegistrar() { return new YalsmItemRegistrar(); }
    @Override
    public CustomConfiguration GetCustomConfiguration() { return this.customConfiguration; }
}
