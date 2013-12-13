package airbreather.mods.yalsm;

import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import airbreather.mods.airbreathercore.item.ItemConfiguration;
import airbreather.mods.airbreathercore.item.ItemDefinition;

// Holds item-related configuration information, specific to YALSM.
final class YalsmItemConfiguration implements ItemConfiguration
{
    private final HashMap<Integer, ItemDefinition> itemMap = new HashMap<Integer, ItemDefinition>(3);

    public YalsmItemConfiguration()
    {
        this.InitializeItemDefinitionsForNonYalsmItems();
    }

    public ItemDefinition GetItemDefinition(int tag)
    {
        return this.itemMap.get(tag);
    }

    public Iterable<Integer> GetNewItemTags()
    {
        ArrayList<Integer> itemTags = new ArrayList<Integer>(1);
        itemTags.add(YalsmConstants.PatchworkID);
        return itemTags;
    }

    public void SetPatchworkItemID(int itemID)
    {
        if (this.itemMap.containsKey(YalsmConstants.PatchworkID))
        {
            return;
        }

        ItemDefinition patchworkItemDefinition = new ItemDefinition(YalsmConstants.PatchworkID,
                                                                    itemID,
                                                                    YalsmConstants.ModID,
                                                                    YalsmConstants.PatchworkItemName);

        this.itemMap.put(patchworkItemDefinition.GetTag(), patchworkItemDefinition);
    }

    private void InitializeItemDefinitionsForNonYalsmItems()
    {
        // This lets us plug non-YALSM items into our recipe framework.
        // Note: having to do this is a deliberate consequence to designing the item framework this way.
        // It means that somewhere, at some point, we have to be explicit about all the items we're using.
        int rottenFleshItemID = Item.rottenFlesh.itemID;
        ItemDefinition rottenFleshItemDefinition = new ItemDefinition(YalsmConstants.RottenFleshID,
                                                                      rottenFleshItemID,
                                                                      YalsmConstants.BaseGameModID,
                                                                      YalsmConstants.RottenFleshItemName);
        this.itemMap.put(rottenFleshItemDefinition.GetTag(), rottenFleshItemDefinition);

        int leatherItemID = Item.leather.itemID;
        ItemDefinition leatherItemDefinition = new ItemDefinition(YalsmConstants.LeatherID,
                                                                  leatherItemID,
                                                                  YalsmConstants.BaseGameModID,
                                                                  YalsmConstants.LeatherItemName);
        this.itemMap.put(leatherItemDefinition.GetTag(), leatherItemDefinition);
    }
}
