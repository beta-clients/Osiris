package io.github.qe7.features.modules.api.settings.impl;

import com.google.gson.JsonObject;
import io.github.qe7.features.modules.api.settings.api.Setting;
import lombok.Getter;

@Getter
public final class IntSetting extends Setting<Integer> {

    private final int minimum, maximum, step;

    public IntSetting(String name, Integer defaultValue, int minimum, int maximum, int step) {
        super(name, defaultValue);
        this.minimum = minimum;
        this.maximum = maximum;
        this.step = step;
    }

    @Override
    public JsonObject serialize() {
        JsonObject object = new JsonObject();

        object.addProperty("value", this.getValue());

        return object;
    }

    @Override
    public void deserialize(JsonObject object) {
        this.setValue(object.get("value").getAsInt());
    }
}
