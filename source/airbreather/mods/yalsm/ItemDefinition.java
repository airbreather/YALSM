package airbreather.mods.yalsm;

// TODO: Stuff this into airbreathercore, and refactor out the item subsystem
// to something more robust that can take advantage of something like this class
// that contains all the necessary information to uniquely identify and locate
// an item from any known consumer's point of view.
final class ItemDefinition
{
    private final int itemID;
    private final int internalID;
    private final String modID;
    private final String itemName;

    public ItemDefinition(int itemID, int internalID, String modID, String itemName)
    {
        this.itemID = itemID;
        this.internalID = internalID;
        this.modID = modID;
        this.itemName = itemName;
    }

    public int GetItemID()
    {
        return this.itemID;
    }

    public int GetInternalID()
    {
        return this.internalID;
    }

    public String GetModID()
    {
        return this.modID;
    }

    public String GetItemName()
    {
        return this.itemName;
    }
}