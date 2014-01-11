package airbreather.mods.yalsm;

import com.google.common.collect.ImmutableList;

import airbreather.mods.airbreathercore.item.ItemConfiguration;
import airbreather.mods.airbreathercore.item.ItemDefinition;

// Holds item-related configuration information, specific to YALSM.
final class YalsmItemConfiguration implements ItemConfiguration
{
    @Override
    public Iterable<ItemDefinition> GetItemDefinitionsForNewItems()
    {
        return ImmutableList.of
        (
            YalsmConstants.PatchworkItemDefinition
        );
    }
}
