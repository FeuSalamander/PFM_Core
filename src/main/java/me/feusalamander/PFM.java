package me.feusalamander;

import me.feusalamander.BlockData.Energy;
import me.feusalamander.BlockData.IDs;
import me.feusalamander.Configs.IDList;
import org.bukkit.plugin.java.JavaPlugin;

public final class PFM extends JavaPlugin {
    public Energy energy;
    public IDList idList;
    public IDs iDs;
    @Override
    public void onEnable(){
        getLogger().info("PFMCore by FeuSalamander is loading");
        saveDefaultConfig();
        this.energy = new Energy(this);
        this.idList = new IDList(this.getDataFolder());
        this.iDs = new IDs(this);
    }
    @Override
    public void onDisable() {
    }
}
