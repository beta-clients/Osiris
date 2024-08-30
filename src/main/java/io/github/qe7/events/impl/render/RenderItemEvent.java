package io.github.qe7.events.impl.render;

import io.github.qe7.events.api.types.Event;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.src.EnumAction;

@Setter
@Getter
public class RenderItemEvent extends Event {

    private EnumAction action;

    private float swingProgress;

    private int useItemCount;

    public RenderItemEvent(final EnumAction action, final float swingProgress, final int useItemCount) {
        this.action = action;
        this.swingProgress = swingProgress;
        this.useItemCount = useItemCount;
    }
}
