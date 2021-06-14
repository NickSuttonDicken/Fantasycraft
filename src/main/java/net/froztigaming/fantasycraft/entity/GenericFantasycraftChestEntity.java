package net.froztigaming.fantasycraft.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvironmentInterface;
import net.fabricmc.api.EnvironmentInterfaces;
import net.froztigaming.fantasycraft.blocks.containers.ChestTypes;
import net.froztigaming.fantasycraft.blocks.containers.GenericFantasycraftChestBlock;
import net.froztigaming.fantasycraft.init.FantasycraftScreenHandlerType;
import net.froztigaming.fantasycraft.screenhandlers.FantasycraftChestScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.*;
import net.minecraft.client.block.ChestAnimationProgress;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.*;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

@EnvironmentInterfaces({@EnvironmentInterface(
        value = EnvType.CLIENT,
        itf = ChestAnimationProgress.class
)})
public class GenericFantasycraftChestEntity extends LootableContainerBlockEntity implements ChestAnimationProgress, BlockEntityProvider {

    private DefaultedList<ItemStack> chestContents;
    protected float lidAngle;
    protected float prevLidAngle;
    public int numPlayersUsing;
    private int ticksSinceSync;
    private final int inventorySize;
    ChestTypes type;

    public GenericFantasycraftChestEntity(BlockEntityType<? extends GenericFantasycraftChestEntity> entity, BlockPos blockPos, BlockState blockState, ChestTypes type) {
        super(entity, blockPos, blockState);
        inventorySize = type.size;
        this.type = type;
        chestContents = DefaultedList.ofSize(inventorySize, ItemStack.EMPTY);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new FantasycraftChestScreenHandler(FantasycraftScreenHandlerType.ELVEN_CHEST, type, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory inventory) {
        return new FantasycraftChestScreenHandler(FantasycraftScreenHandlerType.ELVEN_CHEST, type, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    public DefaultedList<ItemStack> getInvStackList() {
        return chestContents;
    }

    @Override
    public void setInvStackList(DefaultedList<ItemStack> list) {
        this.chestContents = DefaultedList.<ItemStack>ofSize(inventorySize, ItemStack.EMPTY);

        for (int i = 0; i < list.size(); i++) {
            if (i < this.chestContents.size()) {
                this.getInvStackList().set(i, list.get(i));
            }
        }
    }

    @Override
    public int size() {
        return inventorySize;
    }

    @Environment(EnvType.CLIENT)
    public float getAnimationProgress(float tickDelta) {
        return MathHelper.lerp(tickDelta, this.prevLidAngle, this.lidAngle);
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.chestContents) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }


    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        this.chestContents = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(tag)) {
            Inventories.readNbt(tag, this.chestContents);
        }
    }


    public NbtCompound writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        if (!this.serializeLootTable(tag)) {
            Inventories.writeNbt(tag, this.chestContents);
        }
        return tag;
    }


    public void tick() {
        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();
        ++this.ticksSinceSync;
        this.numPlayersUsing = tickViewerCount(this.world, this, this.ticksSinceSync, i, j, k, this.numPlayersUsing);
        this.prevLidAngle = this.lidAngle;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
            this.playSound(SoundEvents.BLOCK_CHEST_OPEN);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
            float f1 = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1F;
            }
            else {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F) {
                this.lidAngle = 1.0F;
            }

            if (this.lidAngle < 0.5F && f1 >= 0.5F) {
                this.playSound(SoundEvents.BLOCK_CHEST_CLOSE);
            }

            if (this.lidAngle < 0.0F) {
                this.lidAngle = 0.0F;
            }
        }
    }

    private void playSound(SoundEvent soundEvent) {
        double d0 = (double) this.pos.getX() + 0.5D;
        double d1 = (double) this.pos.getY() + 0.5D;
        double d2 = (double) this.pos.getZ() + 0.5D;
        this.world.playSound((PlayerEntity) null, d0, d1, d2, soundEvent, SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
    }

    public static int tickViewerCount(World world, LockableContainerBlockEntity blockEntity, int ticksOpen, int x, int y, int z, int viewerCount) {
        if (!world.isClient && viewerCount != 0 && (ticksOpen + x + y + z) % 200 == 0) {
            viewerCount = countViewers(world, x, y, z);
        }
        return viewerCount;
    }

    public static int countViewers(World world, int x, int y, int z) {
        int i = 0;
        for (PlayerEntity playerentity : world.getNonSpectatingEntities(PlayerEntity.class, new Box((double) ((float) x - 5.0F), (double) ((float) y - 5.0F), (double) ((float) z - 5.0F), (double) ((float) (x + 1) + 5.0F), (double) ((float) (y + 1) + 5.0F), (double) ((float) (z + 1) + 5.0F)))) {
            if (playerentity.currentScreenHandler instanceof FantasycraftChestScreenHandler) {
                ++i;
            }
        }
        return i;
    }

    @Override
    public boolean onSyncedBlockEvent(int type, int data) {
        if (type == 1) {
            this.numPlayersUsing = data;
            return true;
        } else {
            return super.onSyncedBlockEvent(type, data);
        }
    }

    @Override
    public void onOpen(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.onInvOpenOrClose();
        }
    }

    @Override
    public void onClose(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.numPlayersUsing;
            this.onInvOpenOrClose();
        }
    }

    protected void onInvOpenOrClose() {
        Block block = this.getCachedState().getBlock();
        if (block instanceof GenericFantasycraftChestBlock) {
            this.world.addSyncedBlockEvent(this.pos, block, 1, this.numPlayersUsing);
            this.world.updateNeighborsAlways(this.pos, block);
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return BlockEntityProvider.super.getTicker(world, state, type);
    }
}
