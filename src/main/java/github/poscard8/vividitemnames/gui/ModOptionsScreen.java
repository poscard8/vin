package github.poscard8.vividitemnames.gui;

import github.poscard8.vividitemnames.NameColor;
import github.poscard8.vividitemnames.ModOptions;
import github.poscard8.vividitemnames.VividItemNames;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.gui.screens.OptionsSubScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.ByIdMap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
@OnlyIn(Dist.CLIENT)
public class ModOptionsScreen extends OptionsSubScreen {

    private OptionsList list;
    private Rarity selectedRarity;

    public ModOptionsScreen(Screen screen, Options options) {
        super(screen, options, Component.translatable("options.vividitemnames"));
    }

    @Override
    protected void init() {
        this.selectedRarity = Rarity.COMMON;
        this.list = this.refreshList();

        Button prevButton = Button.builder(Component.literal("<"), press -> {
            this.selectedRarity = this.selectedRarity.prev();
            this.refreshList();
        }).bounds(this.width / 2 - 90, 36, 20, 20).build();
        Button nextButton = Button.builder(Component.literal(">"), press -> {
            this.selectedRarity = this.selectedRarity.next();
            this.refreshList();
        }).bounds(this.width / 2 + 70, 36, 20, 20).build();
        Button resetButton = Button.builder(Component.translatable("options.item_reset"), press ->
                        this.reset())
                .bounds(this.width / 2 - 100, 139, 200, 20).build();

        this.addRenderableWidget(prevButton);
        this.addRenderableWidget(nextButton);
        this.addRenderableWidget(resetButton);

        assert this.minecraft != null;
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, press -> {
            this.minecraft.options.save();
            this.minecraft.setScreen(this.lastScreen);
        }).bounds(this.width / 2 - 100, this.height - 27, 200, 20).build());

    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float colorCode) {
        this.renderDirtBackground(guiGraphics);
        this.basicListRender(guiGraphics, this.list, mouseX, mouseY, colorCode);
        guiGraphics.drawString(this.font, this.selectedRarity.getComponent(), (this.width - font.width(this.selectedRarity.getComponent())) / 2,
                42, Objects.requireNonNull(this.selectedRarity.getStyle().getColor()).getValue());
    }

    protected OptionsList refreshList() {
        if (this.list != null) {
            this.removeWidget(this.list);
        }

        assert this.minecraft != null;
        this.list = new OptionsList(this.minecraft, this.width, this.height, 60, 139, 25);
        this.list.addSmall(this.selectedRarity.options);

        this.addWidget(this.list);
        return this.list;
    }

    protected void reset() {
        for (OptionInstance<?> optionInstance : this.selectedRarity.options) {
            if (optionInstance.get() instanceof NameColor) {
                ((OptionInstance<NameColor>) optionInstance).set(this.selectedRarity.defaultNameColor);
            } else {
                ((OptionInstance<Boolean>) optionInstance).set(false);
            }
        }

        this.refreshList();
    }

    @OnlyIn(Dist.CLIENT)
    protected enum Rarity {
        COMMON(ModOptions.getInstance().commonItemOptions(), VividItemNames::getCommonStyle, NameColor.WHITE),
        UNCOMMON(ModOptions.getInstance().uncommonItemOptions(), VividItemNames::getUncommonStyle, NameColor.YELLOW),
        RARE(ModOptions.getInstance().rareItemOptions(), VividItemNames::getRareStyle, NameColor.AQUA),
        EPIC(ModOptions.getInstance().epicItemOptions(), VividItemNames::getEpicStyle, NameColor.MAGENTA);

        private static final IntFunction<Rarity> BY_ID = ByIdMap.continuous(Rarity::ordinal, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
        public final OptionInstance<?>[] options;
        public final NameColor defaultNameColor;
        private final Supplier<Style> style;

        Rarity(OptionInstance<?>[] options, Supplier<Style> style, NameColor defaultNameColor) {
            this.options = options;
            this.style = style;
            this.defaultNameColor = defaultNameColor;
        }

        public Style getStyle() {
            return style.get();
        }

        public Component getComponent() {
            return Component.translatable("options." + this.toString().toLowerCase() + "_items").withStyle(this.getStyle());
        }

        public Rarity next() { return BY_ID.apply(this.ordinal() + 1); }

        public Rarity prev() {
            return BY_ID.apply(this.ordinal() - 1);
        }
    }


}
