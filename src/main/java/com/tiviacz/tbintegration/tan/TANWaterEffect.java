package com.tiviacz.tbintegration.tan;

import com.tiviacz.travelersbackpack.api.fluids.effects.FluidEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import toughasnails.api.TANPotions;
import toughasnails.api.config.GameplayOption;
import toughasnails.api.config.SyncedConfig;
import toughasnails.api.stat.capability.IThirst;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.api.thirst.WaterType;

public class TANWaterEffect extends FluidEffect
{
    public static TANWaterEffect WATER_EFFECT;

    public TANWaterEffect()
    {
        super(FluidRegistry.WATER, 250);
    }

    @Override
    public void affectDrinker(FluidStack fluidStack, World world, Entity entity)
    {
        if(entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;

            IThirst thirst = ThirstHelper.getThirstData(player);
            WaterType type = WaterType.NORMAL;
            thirst.addStats(type.getThirst(), type.getHydration());
            addEffects(player, type);
        }
    }

    private void addEffects(EntityPlayer player, WaterType type)
    {
        if(player.world.rand.nextFloat() < type.getPoisonChance() && SyncedConfig.getBooleanValue(GameplayOption.ENABLE_THIRST))
        {
            player.addPotionEffect(new PotionEffect(TANPotions.thirst, 600));
        }
    }

    @Override
    public boolean canExecuteEffect(FluidStack fluidStack, World world, Entity entity)
    {
        return fluidStack.amount >= this.amountRequired;
    }

    public static void registerEffect()
    {
        WATER_EFFECT = new TANWaterEffect();
    }
}
