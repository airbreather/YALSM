package airbreather.mods.yalsm;

import java.util.HashMap;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.LanguageRegistry;
import airbreather.mods.airbreathercore.ItemConfiguration;

// Holds item-related configuration information, specific to YALSM.
final class YalsmItemConfiguration implements ItemConfiguration
{
    private final HashMap<Integer, Item> itemMap = new HashMap<Integer, Item>(1);

    public Item GetItem(int id)
    {
        return this.itemMap.get(id);
    }

    public void SetPatchworkItemID(int itemID)
    {
        if (this.itemMap.containsKey(YalsmConstants.PatchworkID))
        {
            return;
        }

        int patchworkMaxStackSize = 64;
        Item patchworkItem = new Item(itemID).setMaxStackSize(patchworkMaxStackSize)
                                             .setUnlocalizedName(YalsmConstants.PatchworkEnglishName)
                                             .setCreativeTab(CreativeTabs.tabMaterials)
                                             .setTextureName(YalsmConstants.PatchworkTextureID);

        this.itemMap.put(YalsmConstants.PatchworkID, patchworkItem);

        // TODO: Globalize... that's a project for another day.
        LanguageRegistry.addName(patchworkItem, YalsmConstants.PatchworkEnglishName);
    }
}
