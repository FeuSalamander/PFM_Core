package me.feusalamander.BlockData;

import me.feusalamander.PFM;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.TileState;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class IDs {
    private final PFM main;
    private final NamespacedKey idkey;
    public IDs(PFM main){
        this.main= main;
        idkey = new NamespacedKey(main, "pfmid");
    }
    public String getIDof(final Block block){
        if(!(block.getState() instanceof TileState state)) return "";
        PersistentDataContainer data = state.getPersistentDataContainer();
        if(!data.has(idkey, PersistentDataType.STRING)) return "";
        return data.get(idkey, PersistentDataType.STRING);
    }
    public void setIDof(final Block block, final String id){
        if(!(block.getState() instanceof TileState state)) return;
        state.getPersistentDataContainer().set(idkey, PersistentDataType.STRING, id);
        state.update();
    }
}
