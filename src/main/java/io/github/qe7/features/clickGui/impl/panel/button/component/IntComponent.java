package io.github.qe7.features.clickGui.impl.panel.button.component;

import io.github.qe7.features.clickGui.api.types.Component;
import io.github.qe7.features.modules.api.settings.impl.IntSetting;
import io.github.qe7.utils.math.MathUtility;
import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Gui;

import java.awt.*;

public class IntComponent extends Component {

    private final IntSetting setting;

    private final int width = 104, height = 14;

    private float x, y;

    private boolean dragging;

    public IntComponent(IntSetting setting) {
        super(setting);

        this.setting = setting;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float x, float y) {
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

        this.x = x;
        this.y = y;

        final int min = this.setting.getMinimum();
        final int max = this.setting.getMaximum();
        final int value = this.setting.getValue();

        final double percent = (value - min) / (double) (max - min);

        if (this.dragging) {
            final double diff = mouseX - x;
            double newValue = min + (diff / width) * (max - min);
            this.setting.setValue((int) MathUtility.doStep(Math.floor(newValue), this.setting.getStep(), this.setting.getMinimum(), this.setting.getMaximum()));
        }

        if (MathUtility.isHovered(this.x, this.y, this.width, this.height, mouseX, mouseY)) {
            Gui.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, new Color(0, 0, 0, 100).getRGB());
        }

        Gui.drawRect(this.x, this.y + this.height - 2, this.x + (int) (this.width * percent), this.y + this.height, new Color(255, 255, 255, 125).getRGB());

        fontRenderer.drawStringWithShadow(this.getSetting().getName(), x + 2, y + 3, new Color(255, 255, 255).getRGB());
        fontRenderer.drawStringWithShadow(String.valueOf(this.getSetting().getValue()), x + width - 2 - fontRenderer.getStringWidth(String.valueOf(this.getSetting().getValue())), y + 3, new Color(255, 255, 255).getRGB());
    }

    @Override
    public void keyTyped(char c, int i) {

    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int k) {
        if (MathUtility.isHovered(this.x, this.y, this.width, this.height, mouseX, mouseY)) {
            if (k == 0) {
                this.dragging = true;
            }
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int k) {
        if (this.dragging) this.dragging = false;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
