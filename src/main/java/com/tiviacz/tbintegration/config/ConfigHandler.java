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
    }
}
