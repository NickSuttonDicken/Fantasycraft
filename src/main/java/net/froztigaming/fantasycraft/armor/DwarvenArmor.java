package net.froztigaming.fantasycraft.armor;

import net.froztigaming.fantasycraft.FantasycraftMain;
import net.froztigaming.fantasycraft.config.FantasycraftConfig;
import net.froztigaming.fantasycraft.init.ItemInit;
import net.froztigaming.fantasycraft.util.ArmorEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class DwarvenArmor extends ArmorItem {

    int i;
    public DwarvenArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings)
    {
        super(material, slot, settings);
    }

    public static final FantasycraftConfig.BonusEffects CONFIG2 = FantasycraftMain.CONFIG.BONUSEFFECTS;

    static boolean enableArmorSetBonuses = CONFIG2.enableArmorSetBonuses;
    static boolean enableNightVision = CONFIG2.enableNightVision;
    static boolean effectsCleared = true;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(!world.isClient && entity instanceof PlayerEntity && enableArmorSetBonuses)
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
                if (enableNightVision)
                {
                    ArmorEffects.giveNightVisionEffect(world, player);
                    effectsCleared = false;
                }

            }
            else {
                while(effectsCleared == false)
                {
                    ArmorEffects.removeNightVisionEffect(world, player);
                    effectsCleared = true;
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        tooltip.add( new TranslatableText("item.fantasycraft.dwarven_armor.tooltip_1").formatted(Formatting.BOLD) );
        tooltip.add( new TranslatableText("item.fantasycraft.dwarven_armor.tooltip_2").formatted(Formatting.RED) );
        tooltip.add( new TranslatableText("item.fantasycraft.dwarven_armor.tooltip_3").formatted(Formatting.RED) );
        tooltip.add( new TranslatableText("item.fantasycraft.dwarven_armor.tooltip_4").formatted(Formatting.RED) );
    }
}
