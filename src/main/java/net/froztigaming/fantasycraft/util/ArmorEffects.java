package net.froztigaming.fantasycraft.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.CropBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
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
    public static void giveUnderwaterHasteEffect(World world, PlayerEntity player)
    {
        if (player.isSubmergedInWater())
        {
            StatusEffectInstance underWaterHaste = new StatusEffectInstance(StatusEffects.HASTE, 8, 1, false, false);
            {
                player.addStatusEffect(underWaterHaste);
            }
        }
    }

    public static void giveRegenEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance regen = new StatusEffectInstance(StatusEffects.REGENERATION, 50, 0, false, false);
            {
                if (player.age % 20 == 0)
                {
                    player.addStatusEffect(regen);
                }
            }
        }
    }

    public static void giveNightVisionEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance nightVision = new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false);
            {
                if (player.age % 20 == 0)
                {
                    player.addStatusEffect(nightVision);
                }
            }
        }
    }

    public static void giveConduitPowerEffect(World world, PlayerEntity player)
    {
        if (player.isWet())
        {
            StatusEffectInstance conduitPower = new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 8, 0, false, false);
            {
                player.addStatusEffect(conduitPower);
            }
        }
    }

    public static void giveJumpBoostEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance jumpBoost = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 8, 0, false, false);
            {
                player.addStatusEffect(jumpBoost);
            }
        }
    }

    public static void giveSpeedEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance speed = new StatusEffectInstance(StatusEffects.SPEED, 8, 0, false, false);
            {
                player.addStatusEffect(speed);
            }
        }
    }

    public static void giveInvisibilityEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            StatusEffectInstance invisibility = new StatusEffectInstance(StatusEffects.INVISIBILITY, 3600, 0, false, false);
            {
                player.addStatusEffect(invisibility);
            }
        }
    }

    public static void clearEffects(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            player.clearStatusEffects();
        }
    }

    public static void removeNightVisionEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            player.removeStatusEffect(StatusEffects.NIGHT_VISION);
        }
    }

    public static void removeRegenEffect(World world, PlayerEntity player)
    {
        if (player.isAlive())
        {
            player.removeStatusEffect(StatusEffects.REGENERATION);
        }
    }
}
