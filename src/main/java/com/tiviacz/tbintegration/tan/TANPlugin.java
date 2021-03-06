package com.tiviacz.tbintegration.tan;

import com.tiviacz.tbintegration.TBIntegration;
import com.tiviacz.travelersbackpack.api.integration.ITBPlugin;
import com.tiviacz.travelersbackpack.api.integration.TBPlugin;
import net.minecraftforge.fml.common.Loader;

@TBPlugin
public class TANPlugin implements ITBPlugin
{
    @Override
    public String getModName()
    {
        return "Tough As Nails";
    }

    @Override
    public boolean canLoad()
    {
        return Loader.isModLoaded("toughasnails") && TBIntegration.loadTAN;
    }

    @Override
    public void preInit() { }

    @Override
    public void init()
    {
        TANPurifiedWaterEffect.registerEffect();
        TANWaterEffect.registerEffect();
        TANPurifiedWaterInventoryRecipes.registerRecipes();
    }

    @Override
    public void postInit() { }
}
