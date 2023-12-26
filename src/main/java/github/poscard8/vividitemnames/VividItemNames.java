package github.poscard8.vividitemnames;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod(VividItemNames.ID)
public class VividItemNames {

    public static final String ID = "vividitemnames";

    public static final VividItemNamesOptions OPTIONS = VividItemNamesOptions.getInstance();

    public static final Component TITLE = CommonComponents.EMPTY.copy()
            .append(Component.literal("V").withStyle(Style.EMPTY.withColor(ChatFormatting.LIGHT_PURPLE).withBold(true).withItalic(true)))
            .append(Component.literal("I").withStyle(Style.EMPTY.withColor(ChatFormatting.GREEN).withBold(true).withItalic(true)))
            .append(Component.literal("N").withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD).withBold(true).withItalic(true)));

    public VividItemNames() {
    }

}
