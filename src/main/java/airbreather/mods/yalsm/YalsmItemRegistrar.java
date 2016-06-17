package airbreather.mods.yalsm;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import airbreather.mods.airbreathercore.item.ItemDefinition;
import airbreather.mods.airbreathercore.item.ItemRegistrarBase;

import static com.google.common.base.Preconditions.checkNotNull;

// A helper class to register all the items added by this mod.
final class YalsmItemRegistrar extends ItemRegistrarBase
{
    @Override
    public Item CreateItemCore(ItemDefinition definition)
    {
        checkNotNull(definition, "definition");

        if (definition.equals(YalsmConstants.PatchworkItemDefinition))
        {
            return CreatePatchworkItem(definition);
        }

        return super.CreateItemCore(definition);
    }

    private static Item CreatePatchworkItem(ItemDefinition patchworkItemDefinition)
    {
        // The registry itself is expected to set the common properties derived from the ModID and/or item name.
        int patchworkMaxStackSize = 64;
        Item patchworkItem = new Item().setMaxStackSize(patchworkMaxStackSize)
                                       .setCreativeTab(CreativeTabs.MATERIALS);

        return patchworkItem;
    }
}
