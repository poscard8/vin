package github.poscard8.vividitemnames.mixin;

import github.poscard8.vividitemnames.VividItemNames;
import github.poscard8.vividitemnames.gui.ModOptionsScreen;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.screens.OptionsScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@SuppressWarnings("ALL")
@OnlyIn(Dist.CLIENT)
@Mixin(OptionsScreen.class)
public abstract class OptionsScreenMixin extends Screen {

    private OptionsScreenMixin(Component component) {
        super(component);
    }

    @Shadow
    private Options options;

    private final OptionsScreen self = (OptionsScreen) (Object) this;
    private final Button modOptionsButton = new Button.Builder(VividItemNames.getButtonComponent(), onPress -> self.getMinecraft().setScreen(new ModOptionsScreen(self, this.options))).size(20, 20).build();

    @Inject(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/layouts/GridLayout;arrangeElements()V", shift = At.Shift.BEFORE),
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void addModOptionsButton(CallbackInfo ci, GridLayout gridLayout, GridLayout.RowHelper rowHelper) {
        rowHelper.addChild(this.modOptionsButton, rowHelper.newCellSettings().padding(0, -78).align(2.275F, 0));
    }


}
