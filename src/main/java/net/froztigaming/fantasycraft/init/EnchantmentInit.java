package net.froztigaming.fantasycraft.init;

import net.froztigaming.fantasycraft.util.enchantments.PoisonEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;

import static net.froztigaming.fantasycraft.FantasycraftMain.MOD_ID;

public class EnchantmentInit {

    public static final Enchantment POISON = new PoisonEnchantment();

    public static void registerEnchantments()
    {
        Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "poison"), POISON);
    }
}
