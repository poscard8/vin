package github.poscard8.vividitemnames.mixin;

import github.poscard8.vividitemnames.util.VividItemNamesUtils;
import net.minecraft.client.gui.Gui;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@SuppressWarnings("ALL")
@Mixin(Gui.class)
public abstract class GuiMixin {

    @Shadow
    private ItemStack lastToolHighlight;

    @ModifyVariable(method = "renderSelectedItemName(Lnet/minecraft/client/gui/GuiGraphics;I)V", at = @At("STORE"), ordinal = 0, remap = false)
    private Component changeComponent(Component component) {
        return VividItemNamesUtils.wrapInEnclosure(component, this.lastToolHighlight.getRarity(), this.lastToolHighlight.hasCustomHoverName());
    }

}
