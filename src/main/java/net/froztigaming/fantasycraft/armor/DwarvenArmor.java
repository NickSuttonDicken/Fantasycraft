package net.froztigaming.fantasycraft.armor;

import net.froztigaming.fantasycraft.init.ItemInit;
import net.froztigaming.fantasycraft.util.ArmorEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DwarvenArmor extends ArmorItem {

    int i;
    public DwarvenArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings)
    {
        super(material, slot, settings);
    }

    static boolean enablePerks = true;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(!world.isClient && entity instanceof PlayerEntity && enablePerks)
        {
            PlayerEntity player = (PlayerEntity) entity;

            ItemStack head = player.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack chest = player.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack legs = player.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack feet = player.getEquippedStack(EquipmentSlot.FEET);

            if((head.getItem() == ItemInit.DWARVEN_HELMET &&
                    chest.getItem() == ItemInit.DWARVEN_CHESTPLATE &&
                    legs.getItem() == ItemInit.DWARVEN_LEGGINGS &&
                    feet.getItem() == ItemInit.DWARVEN_BOOTS))
            {
                ArmorEffects.giveHasteEffect(world, player);
                ArmorEffects.giveFireResistanceEffect(world, player);
                ArmorEffects.giveNightVisionEffect(world, player);
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
