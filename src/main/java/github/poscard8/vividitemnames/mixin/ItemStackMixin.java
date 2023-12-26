package github.poscard8.vividitemnames.mixin;

import github.poscard8.vividitemnames.util.VividItemNamesUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@SuppressWarnings("ALL")
@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow
    abstract boolean hasCustomHoverName();

    @Inject(method = "getRarity", at = @At("RETURN"), cancellable = true)
    private void changeRarity(CallbackInfoReturnable<Rarity> ci) {
        ci.setReturnValue(VividItemNamesUtils.changeRarity(ci.getReturnValue()));
    }

    @Inject(method = "getTooltipLines", at = @At("RETURN"), cancellable = true)
    private void changeTooltipLines(@Nullable Player player, TooltipFlag flag, CallbackInfoReturnable<List<Component>> ci) {

        List<Component> components = ci.getReturnValue();
        Component nameComponent = components.get(0);
        components.remove(0);
        components.add(0, VividItemNamesUtils.wrapInEnclosure(nameComponent, ((ItemStack)(Object)this).getRarity(), hasCustomHoverName()));
    }

}
