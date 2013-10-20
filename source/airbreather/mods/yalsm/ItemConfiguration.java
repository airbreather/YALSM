package airbreather.mods.yalsm;

import net.minecraft.item.Item;

// An interface for a configuration that maps IDs (used internally) to Item objects.
public interface ItemConfiguration
{
    // Gets the Item configured by a given id.
    Item GetItem(int id);
}
