package net.froztigaming.fantasycraft.tools.malachite;

import net.froztigaming.fantasycraft.register.Registration;
import net.froztigaming.fantasycraft.util.ArmorEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class TritonPickaxe extends PickaxeItem {
    public TritonPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
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

            if(mainHand.getItem() == Registration.TRITON_PICKAXE)
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
