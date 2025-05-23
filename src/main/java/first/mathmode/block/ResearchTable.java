package first.mathmode.block;

import first.mathmode.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ResearchTable extends Block {
    public ResearchTable(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (!world.isClient) {
            player.sendMessage(Text.literal("You clicked on Research Table!"), false);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        Vec3d vec3d = Vec3d.add(pos, (double)0.5F, (double)0.2F, (double)0.5F).addRandom(world.random, 0.7F);
        ItemEntity itemEntity = new ItemEntity(world, vec3d.getX(), vec3d.getY(), vec3d.getZ(), new ItemStack(ModBlocks.RESEARCH_TABLE));
        itemEntity.setToDefaultPickupDelay();
        world.spawnEntity(itemEntity);

        return state;
    }


    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.PAPER)) {
            stack.decrementUnlessCreative(1, player);
            Vec3d vec3d = Vec3d.add(pos, (double)0.5F, 1.01, (double)0.5F).addRandom(world.random, 0.7F);
            ItemEntity itemEntity = new ItemEntity(world, vec3d.getX(), vec3d.getY(), vec3d.getZ(), new ItemStack(ModItems.RESEARCH_PAPER_TIER_0));
            itemEntity.setToDefaultPickupDelay();
            world.spawnEntity(itemEntity);
        } else {
            return this.onUse(state, world, pos, player, hit);
        }
        return ActionResult.SUCCESS;
    }

}
