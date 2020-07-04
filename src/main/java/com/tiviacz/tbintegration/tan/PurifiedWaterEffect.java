package com.tiviacz.tbintegration.tan;

import com.tiviacz.travelersbackpack.api.fluids.effects.FluidEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import toughasnails.api.TANPotions;
import toughasnails.api.config.GameplayOption;
import toughasnails.api.config.SyncedConfig;
import toughasnails.api.stat.capability.IThirst;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.api.thirst.WaterType;
import toughasnails.thirst.ThirstHandler;

public class PurifiedWaterEffect extends FluidEffect
{
    public static PurifiedWaterEffect PURIFIED_WATER_EFFECT;

    public PurifiedWaterEffect()
    {
        super("purified_water", 250);
    }

    @Override
    public void affectDrinker(FluidStack fluidStack, World world, Entity entity)
    {
        if(entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;

            IThirst thirst = ThirstHelper.getThirstData(player);
            WaterType type = WaterType.PURIFIED;
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
        if(entity instanceof EntityPlayer)
        {
            ThirstHandler thirstHandler = (ThirstHandler)ThirstHelper.getThirstData((EntityPlayer)entity);

            return thirstHandler.isThirsty();
        }
        return false;
    }

    public static void registerEffect()
    {
        PURIFIED_WATER_EFFECT = new PurifiedWaterEffect();
    }
}
