package net.froztigaming.fantasycraft.tools.prismarine;

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

    static boolean enablePerks = true;
    static boolean effectsCleared = true;

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
                effectsCleared = false;
            }
            else {
                while(effectsCleared == false)
                {
                    ArmorEffects.clearEffects(world, player);
                    effectsCleared = true;
                }
            }
        }
    }
}
