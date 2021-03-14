package net.froztigaming.fantasycraft.entity;


import net.minecraft.datafixer.fix.EntityTippedArrowFix;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.
import net.minecraft.world.World;

public class ElvenArrowEntity extends ArrowEntity {

    public ElvenArrowEntity(World worldIn) {
        super(worldIn);
    }
    
    public ElvenArrowEntity(EntityType<? extends ElvenArrowEntity> shooter, World worldIn) {
        super(shooter, worldIn);
    }

    public ElvenArrowEntity(World worldIn, LivingEntity shooter) {
        super(worldIn, shooter);
    }



}
