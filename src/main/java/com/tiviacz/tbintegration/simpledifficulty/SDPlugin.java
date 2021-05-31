package com.tiviacz.tbintegration.simpledifficulty;

import com.tiviacz.tbintegration.TBIntegration;
import com.tiviacz.travelersbackpack.api.integration.ITBPlugin;
import com.tiviacz.travelersbackpack.api.integration.TBPlugin;
import net.minecraftforge.fml.common.Loader;

@TBPlugin
public class SDPlugin implements ITBPlugin
{
    @Override
    public String getModName()
    {
        return "Simple Difficulty";
    }

    @Override
    public boolean canLoad()
    {
        return Loader.isModLoaded("simpledifficulty") && TBIntegration.loadSD;
    }

    @Override
    public void preInit() { }

    @Override
    public void init()
    {
        SDPurifiedWaterEffect.registerEffect();
        SDPurifiedWaterInventoryRecipes.registerRecipes();
    }

    @Override
    public void postInit() { }
}
