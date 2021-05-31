package com.tiviacz.tbintegration.simpledifficulty;

import com.charles445.simpledifficulty.api.SDCapabilities;
import com.charles445.simpledifficulty.api.config.QuickConfig;
import com.charles445.simpledifficulty.api.thirst.IThirstCapability;
import com.charles445.simpledifficulty.api.thirst.ThirstEnum;
import com.charles445.simpledifficulty.api.thirst.ThirstUtil;
import com.tiviacz.travelersbackpack.api.fluids.effects.FluidEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class SDPurifiedWaterEffect extends FluidEffect
{
    public static SDPurifiedWaterEffect PURIFIED_WATER_EFFECT;

    public SDPurifiedWaterEffect()
    {
        super("purifiedwater", 250);
    }

    @Override
    public void affectDrinker(FluidStack fluidStack, World world, Entity entity)
    {
        if(entity instanceof EntityPlayer)
        {
            ThirstUtil.takeDrink((EntityPlayer)entity, ThirstEnum.PURIFIED.getThirst(), ThirstEnum.PURIFIED.getSaturation(), ThirstEnum.PURIFIED.getThirstyChance());
        }
    }

    @Override
    public boolean canExecuteEffect(FluidStack fluidStack, World world, Entity entity)
    {
        if(entity instanceof EntityPlayer)
        {
            if(QuickConfig.isThirstEnabled())
            {
                IThirstCapability capability = SDCapabilities.getThirstData((EntityPlayer)entity);

                return capability.isThirsty() && fluidStack.amount >= this.amountRequired;
            }
        }
        return false;
    }

    public static void registerEffect()
    {
        PURIFIED_WATER_EFFECT = new SDPurifiedWaterEffect();
    }
}
