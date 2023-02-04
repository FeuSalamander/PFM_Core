package me.feusalamander.Configs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class IDList {
    //The list of all the modded machines
    private final File file;
    private final YamlConfiguration config;
    public IDList(final File folder){
        file = new File(folder, "IDList.yml");
        if(!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException e) {throw new RuntimeException(e);}
        }
        config = YamlConfiguration.loadConfiguration(file);
        for(Plugin p : Bukkit.getPluginManager().getPlugins()){
            if(p.getDescription().getDepend().contains("PFMCore")){
                if(!config.contains(p.getName())){
                    config.set(p.getName(), List.of(""));
                }

            }
        }
        try{
            config.save(file);
        }catch (IOException e){throw new RuntimeException(e);}
    }
    public List<String> getList(final Plugin plugin){
        //get the id list of a PFM plugin
        return config.getStringList(plugin.getName());
    }
    public void setList(final Plugin plugin, final List<String> content){
        //set the id list of a PFM plugin
        config.set(plugin.getName(), content);
        try{
            config.save(file);
        }catch (IOException e){throw new RuntimeException(e);}
    }
}
