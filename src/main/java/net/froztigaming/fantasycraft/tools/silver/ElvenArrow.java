package net.froztigaming.fantasycraft.tools.silver;

import net.froztigaming.fantasycraft.entity.ElvenArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ElvenArrow extends ArrowItem {
    public ElvenArrow(Item.Settings settings) {
        super(settings);
    }

    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        ElvenArrowEntity elvenArrowEntity = new ElvenArrowEntity(world, shooter);
        elvenArrowEntity.initFromStack(stack);
        System.out.println("createArrow method called");
        return elvenArrowEntity;
    }
}
