package me.feusalamander.BlockData;

import me.feusalamander.PFM;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.TileState;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Energy{
    private final PFM main;
    private final NamespacedKey rflevel;
    private final NamespacedKey maxrf;
    public Energy(PFM main){
        this.main = main;
        rflevel = new NamespacedKey(main, "rf");
        maxrf = new NamespacedKey(main, "maxrf");
    }
    public Double getEnergyof(final Block block){
        if(!(block.getState() instanceof TileState state)) return 0D;
        PersistentDataContainer data = state.getPersistentDataContainer();
        if(!data.has(rflevel, PersistentDataType.DOUBLE)) return 0D;
        return data.get(rflevel, PersistentDataType.DOUBLE);
    }
    public void setEnergyof(final Block block, final Double energylevel){
        if(!(block.getState() instanceof TileState state)) return;
        state.getPersistentDataContainer().set(rflevel, PersistentDataType.DOUBLE,energylevel);
        state.update();
    }
    public void addEnergyto(final Block block, final Double energylevel){
        if(!(block.getState() instanceof TileState state)) return;
        state.getPersistentDataContainer().set(rflevel, PersistentDataType.DOUBLE,
                getEnergyof(block)+energylevel);
        state.update();
    }
    public Double getMaxEnergyof(final Block block){
        if(!(block.getState() instanceof TileState state)) return 0D;
        PersistentDataContainer data = state.getPersistentDataContainer();
        if(!data.has(maxrf, PersistentDataType.DOUBLE)) return 0D;
        return data.get(maxrf, PersistentDataType.DOUBLE);
    }
    public void setMaxEnergyof(final Block block, final Double maxenergy){
        if(!(block.getState() instanceof TileState state)) return;
        state.getPersistentDataContainer().set(maxrf, PersistentDataType.DOUBLE,maxenergy);
        state.update();
    }
}
