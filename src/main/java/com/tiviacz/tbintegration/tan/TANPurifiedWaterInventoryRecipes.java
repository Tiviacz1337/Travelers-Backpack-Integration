package com.tiviacz.tbintegration.tan;

import com.tiviacz.travelersbackpack.api.inventory.InventoryRecipe;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.FluidRegistry;
import toughasnails.api.item.TANItems;

public class TANPurifiedWaterInventoryRecipes
{
    public static TANPurifiedWaterInventoryRecipeIn RECIPE_IN;
    public static TANPurifiedWaterInventoryRecipeOut RECIPE_OUT;

    public static void registerRecipes()
    {
        RECIPE_IN = new TANPurifiedWaterInventoryRecipeIn();
        RECIPE_OUT = new TANPurifiedWaterInventoryRecipeOut();
    }

    public static class TANPurifiedWaterInventoryRecipeIn extends InventoryRecipe
    {
        public TANPurifiedWaterInventoryRecipeIn()
        {
            super(TANItems.purified_water_bottle, FluidRegistry.getFluid("purified_water"), 100, Items.GLASS_BOTTLE);
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

    public static class TANPurifiedWaterInventoryRecipeOut extends InventoryRecipe
    {
        public TANPurifiedWaterInventoryRecipeOut()
        {
            super(Items.GLASS_BOTTLE, FluidRegistry.getFluid("purified_water"), -250, TANItems.purified_water_bottle);
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
