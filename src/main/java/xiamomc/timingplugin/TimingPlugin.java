package xiamomc.timingplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class TimingPlugin extends JavaPlugin {
    public static TimingPlugin instance;

    public static TimingPlugin GetInstance()
    {
        return instance;
    }
    @Override
    public void onEnable() {
        getLogger().info("Starting Timing Plugin...");
        new ScoreboardHandler();
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling Timing Plugin...");
    }
}
