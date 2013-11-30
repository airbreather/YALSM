package airbreather.mods.yalsm;

import java.util.HashMap;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
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

        // TODO: after a proper refactoring with actual design in mind, we'll probably just return
        // this ItemDefinition and let the consumer deal with wiring things up.
        // Putting that off till later, since I have a couple of competing ideas, and I want to get
        // a 1.7-friendly version of this out as quickly as reasonably possible.
        ItemDefinition patchworkItemDefinition = new ItemDefinition(itemID,
                                                                    YalsmConstants.PatchworkID,
                                                                    YalsmConstants.ModID,
                                                                    YalsmConstants.PatchworkItemName);

        // TODO: move unlocalizedName and textureName stuff somewhere higher up
        // so I don't have to keep writing these.
        String unlocalizedName = patchworkItemDefinition.GetItemName();

        String textureName = String.format("%s:%s",
                                           patchworkItemDefinition.GetModID(),
                                           patchworkItemDefinition.GetItemName());

        int patchworkMaxStackSize = 64;
        Item patchworkItem = new Item(itemID).setMaxStackSize(patchworkMaxStackSize)
                                             .setUnlocalizedName(unlocalizedName)
                                             .setCreativeTab(CreativeTabs.tabMaterials)
                                             .setTextureName(textureName);

        this.itemMap.put(patchworkItemDefinition.GetInternalID(), patchworkItem);

        // TODO: this DEFINITELY should be done somewhere else.
        GameRegistry.registerItem(patchworkItem,
                                  patchworkItemDefinition.GetItemName(),
                                  patchworkItemDefinition.GetModID());
    }
}
