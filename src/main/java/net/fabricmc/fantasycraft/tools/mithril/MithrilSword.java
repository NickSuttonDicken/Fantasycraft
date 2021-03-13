package net.fabricmc.fantasycraft.tools.mithril;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class MithrilSword extends SwordItem {
    public MithrilSword(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
