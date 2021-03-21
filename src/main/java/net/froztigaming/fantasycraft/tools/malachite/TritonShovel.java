package net.froztigaming.fantasycraft.tools.malachite;

import net.froztigaming.fantasycraft.init.ItemInit;
import net.froztigaming.fantasycraft.util.ArmorEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class TritonShovel extends ShovelItem {
    public TritonShovel(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    int i;

    static boolean enablePerks = true;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(!world.isClient && entity instanceof PlayerEntity && enablePerks)
        {
            PlayerEntity player = (PlayerEntity) entity;

            ItemStack mainHand = player.getMainHandStack();

            if(mainHand.getItem() == ItemInit.TRITON_SHOVEL)
            {
                ArmorEffects.giveUnderwaterHasteEffect(world, player);
                i = 0;
            }
            else {
                for (i = 0; i < 1; i++)
                {
                    ArmorEffects.clearEffects(world, player);
                }
            }
        }
    }
}
