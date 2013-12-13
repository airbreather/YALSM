package airbreather.mods.yalsm;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import airbreather.mods.airbreathercore.item.ItemConfiguration;
import airbreather.mods.airbreathercore.item.ItemDefinition;
import airbreather.mods.airbreathercore.item.ItemRegistrarBase;
import airbreather.mods.airbreathercore.item.ItemRegistry;

// A helper class to register all the items added by this mod.
final class YalsmItemRegistrar extends ItemRegistrarBase
{
    @Override
    public Item CreateItemCore(ItemDefinition definition)
    {
        int tag = definition.GetTag();
        if (tag == YalsmConstants.PatchworkID)
        {
            return CreatePatchworkItem(definition);
        }

        return super.CreateItemCore(definition);
    }

    private static Item CreatePatchworkItem(ItemDefinition patchworkItemDefinition)
    {
        int itemID = patchworkItemDefinition.GetItemID();

        // The registry itself is expected to set the common properties derived from the ModID and/or item name.
        int patchworkMaxStackSize = 64;
        Item patchworkItem = new Item(itemID).setMaxStackSize(patchworkMaxStackSize)
                                             .setCreativeTab(CreativeTabs.tabMaterials);

        return patchworkItem;
    }
}
