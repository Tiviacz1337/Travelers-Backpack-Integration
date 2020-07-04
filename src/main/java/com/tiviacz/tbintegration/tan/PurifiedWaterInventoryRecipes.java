package com.tiviacz.tbintegration.tan;

import com.tiviacz.travelersbackpack.api.inventory.InventoryRecipe;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.FluidRegistry;
import toughasnails.api.item.TANItems;
import toughasnails.fluids.PurifiedWaterFluid;

public class PurifiedWaterInventoryRecipes
{
    public static PurifiedWaterInventoryRecipeIn RECIPE_IN;
    public static PurifiedWaterInventoryRecipeOut RECIPE_OUT;

    public static void registerRecipes()
    {
        RECIPE_IN = new PurifiedWaterInventoryRecipeIn();
        RECIPE_OUT = new PurifiedWaterInventoryRecipeOut();
    }

    public static class PurifiedWaterInventoryRecipeIn extends InventoryRecipe
    {
        public PurifiedWaterInventoryRecipeIn()
        {
            super(TANItems.purified_water_bottle, PurifiedWaterFluid.instance, 250, Items.GLASS_BOTTLE);
        }

        @Override
        public SoundEvent getSoundEventFill()
        {
            return SoundEvents.ITEM_BOTTLE_FILL;
        }

        @Override
        public SoundEvent getSoundEventEmpty()
        {
            return SoundEvents.ITEM_BOTTLE_EMPTY;
        }
    }

    public static class PurifiedWaterInventoryRecipeOut extends InventoryRecipe
    {
        public PurifiedWaterInventoryRecipeOut()
        {
            super(Items.GLASS_BOTTLE, PurifiedWaterFluid.instance, -250, TANItems.purified_water_bottle);
        }

        @Override
        public SoundEvent getSoundEventFill()
        {
            return SoundEvents.ITEM_BOTTLE_FILL;
        }

        @Override
        public SoundEvent getSoundEventEmpty()
        {
            return SoundEvents.ITEM_BOTTLE_EMPTY;
        }
    }
}
