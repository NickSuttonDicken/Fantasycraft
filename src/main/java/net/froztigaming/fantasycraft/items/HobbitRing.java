package net.froztigaming.fantasycraft.items;

import net.froztigaming.fantasycraft.util.ArmorEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HobbitRing extends Item {
    public HobbitRing(Settings settings){
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        ItemStack stack = playerEntity.getStackInHand(hand);


        if (!world.isClient) {
            ArmorEffects.giveInvisibilityEffect(world, playerEntity);
            stack.damage(1, playerEntity, (p) -> {
                p.sendToolBreakStatus(hand);
            });
            playerEntity.getItemCooldownManager().set(this, 4800);
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, stack);


    }
}
