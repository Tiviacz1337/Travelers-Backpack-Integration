package com.tiviacz.tbintegration.config;

import com.tiviacz.tbintegration.TBIntegration;
import net.minecraftforge.common.config.Config;

@Config(modid = TBIntegration.MODID)
public class ConfigHandler
{
    public static final General general = new General();

    public static class General
    {
        @Config.Name("Tough As Nails")
        @Config.Comment("Whether or not to load the Tough As Nails integration.")
        public boolean loadTAN = true;

        @Config.Name("Simple Difficulty")
        @Config.Comment("Whether or not to load the Simple Difficulty integration.")
        public boolean loadSD = true;

        @Config.Name("Gravestone mod - Graves")
        @Config.Comment("Whether or not to load the Gravestone mod - Graves integration.")
        public boolean loadGMG = true;
    }
}
