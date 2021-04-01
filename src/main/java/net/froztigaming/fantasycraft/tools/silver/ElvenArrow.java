package net.froztigaming.fantasycraft.tools.silver;

import net.froztigaming.fantasycraft.entity.ElvenArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ElvenArrow extends ArrowItem {
    public ElvenArrow(Settings settings) {
        super(settings);
    }

    private double damage = 4;

    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        ElvenArrowEntity elvenArrowEntity = new ElvenArrowEntity(world, shooter);
        elvenArrowEntity.initFromStack(stack);
        elvenArrowEntity.setDamage(this.damage);
        System.out.println("createArrow method called");
        return elvenArrowEntity;
    }

    public double getDamage () {

        return this.damage;
    }

    public ElvenArrow setDamage (double damage) {

        this.damage = damage;
        return this;
    }


}
