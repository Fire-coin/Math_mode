package first.mathmode.item;

import first.mathmode.block.ResearchTable;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class EnergyRod extends Item {
    public EnergyRod(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        // Only do this on the server
        if (!world.isClient) {
            // Check what the player is looking at
            HitResult hitResult = user.raycast(5.0D, 0.0F, false);
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHit = (BlockHitResult) hitResult;
                BlockState blockState = world.getBlockState(blockHit.getBlockPos());
                Block block = blockState.getBlock();
                if (block instanceof ChestBlock ||
                    block instanceof EnderChestBlock ||
                    block instanceof SignBlock ||
                    block instanceof AbstractFurnaceBlock ||
                    block instanceof ShulkerBoxBlock ||
                    block instanceof BeaconBlock ||
                    block instanceof EndPortalFrameBlock ||
                    block instanceof Portal ||
                    block instanceof ResearchTable ||
                    block instanceof EnchantingTableBlock ||
                    block instanceof CraftingTableBlock ||
                    block instanceof SmithingTableBlock ||
                    block instanceof AnvilBlock ||
                    block instanceof BrewingStandBlock ||
                    block instanceof BarrelBlock ||
                    block instanceof DragonEggBlock ||
                    block instanceof RespawnAnchorBlock) {
                    return ActionResult.PASS;
                }
                // Get the position of the block being looked at
                var pos = blockHit.getBlockPos();

                // Replace that block with water
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getEntityWorld();
        if (world.getRandom().nextInt(1000) == 0) {
            target.kill((ServerWorld) world);
        }
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity instanceof SheepEntity) {
            ((SheepEntity) entity).setColor(DyeColor.YELLOW);
        }
        return ActionResult.SUCCESS;
    }
}
