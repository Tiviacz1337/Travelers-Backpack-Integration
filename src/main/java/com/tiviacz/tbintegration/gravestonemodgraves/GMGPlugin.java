package com.tiviacz.tbintegration.gravestonemodgraves;

import com.tiviacz.tbintegration.TBIntegration;
import com.tiviacz.travelersbackpack.api.integration.ITBPlugin;
import com.tiviacz.travelersbackpack.api.integration.TBPlugin;
import net.minecraftforge.fml.common.Loader;

@TBPlugin
public class GMGPlugin implements ITBPlugin
{
    @Override
    public String getModName()
    {
        return "Gravestone mod - Graves";
    }

    @Override
    public boolean canLoad()
    {
        return Loader.isModLoaded("gravestone") && TBIntegration.loadGMG;
    }

    @Override
    public void preInit() { }

    @Override
    public void init()
    {

    }

    @Override
    public void postInit() { }
}
