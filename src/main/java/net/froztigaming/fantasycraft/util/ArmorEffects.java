package net.froztigaming.fantasycraft.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ArmorEffects {

    public static void giveSlownessEffect(World world, PlayerEntity player)
    {
        if(player.isAlive())
        {
            StatusEffectInstance slowness = new StatusEffectInstance(StatusEffects.SLOWNESS, 8,1, false, false);
            {
                player.addStatusEffect(slowness);
            }
            return;
        }
        return;
    }

    public static void giveDolphinGraceEffect(World world, PlayerEntity player)
    {
        if (player.isSubmergedInWater())
        {
            StatusEffectInstance dolphinGrace = new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 8, 1, false, true);
            {
                player.addStatusEffect(dolphinGrace);
            }
        }
    }

    public static void giveFireResistanceEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance fireResistance = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 8, 1, false, true);
            {
                player.addStatusEffect(fireResistance);
            }
        }
    }

    public static void giveHasteEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance haste = new StatusEffectInstance(StatusEffects.HASTE, 8, 1, false, true);
            {
                player.addStatusEffect(haste);
            }
        }
    }

    public static void giveRegenEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance regen = new StatusEffectInstance(StatusEffects.REGENERATION, 8, 1, false, true);
            {
                player.addStatusEffect(regen);
            }
        }
    }
}
