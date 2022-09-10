package xiamomc.timingplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class TimingPlugin extends JavaPlugin {
    public static TimingPlugin instance;

    public TimingPlugin()
    {
        if (instance != null)
            getLogger().warning("Instance is null!");

        instance = this;
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
