package com.tiviacz.tbintegration;

import com.tiviacz.tbintegration.config.ConfigHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = TBIntegration.MODID, name = TBIntegration.NAME, version = TBIntegration.VERSION, dependencies = "required-after:forge@[forgeversion,);required-after:travelersbackpack@[1.0.30,]"
        ,updateJSON = "https://gist.githubusercontent.com/Tiviacz1337/48466aa9fc9b7cc9b7311b46b36b43f5/raw")
public class TBIntegration
{
    public static final String MODID = "tbintegration";
    public static final String NAME = "Traveler's Backpack Integration";
    public static final String VERSION = "1.0.0";

    public static boolean loadTAN;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);

        loadTAN = ConfigHandler.general.loadTAN;

        registerIntegrations();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

    private void registerIntegrations()
    {

    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.getModID().equals(TBIntegration.MODID))
        {
            ConfigManager.sync(TBIntegration.MODID, Config.Type.INSTANCE);
        }
    }
}