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
            StatusEffectInstance slowness = new StatusEffectInstance(StatusEffects.SLOWNESS, 8,0, false, false);
            {
                player.addStatusEffect(slowness);
            }
            return;
        }
        return;
    }

    public static void giveDolphinGraceEffect(World world, PlayerEntity player)
    {
        if (player.isWet())
        {
            StatusEffectInstance dolphinGrace = new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 8, 0, false, false);
            {
                player.addStatusEffect(dolphinGrace);
            }
        }
    }

    public static void giveFireResistanceEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance fireResistance = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 8, 0, false, false);
            {
                player.addStatusEffect(fireResistance);
            }
        }
    }

    public static void giveHasteEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance haste = new StatusEffectInstance(StatusEffects.HASTE, 8, 0, false, false);
            {
                player.addStatusEffect(haste);
            }
        }
    }

    public static void giveRegenEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance regen = new StatusEffectInstance(StatusEffects.REGENERATION, 8, 0, false, false);
            {
                player.addStatusEffect(regen);
            }
        }
    }

    public static void giveNightVisionEffect(World word, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance nightVision = new StatusEffectInstance(StatusEffects.NIGHT_VISION, 8, 0, false, false);
            {
                player.addStatusEffect(nightVision);
            }
        }
    }

    public static void giveConduitPowerEffect(World word, PlayerEntity player)
    {
        if (player.isWet())
        {
            StatusEffectInstance conduitPower = new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 8, 0, false, false);
            {
                player.addStatusEffect(conduitPower);
            }
        }
    }

    public static void giveJumpBoostEffect(World word, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance jumpBoost = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 8, 0, false, false);
            {
                player.addStatusEffect(jumpBoost);
            }
        }
    }

    public static void giveSpeedEffect(World word, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance speed = new StatusEffectInstance(StatusEffects.SPEED, 8, 0, false, false);
            {
                player.addStatusEffect(speed);
            }
        }
    }
}
