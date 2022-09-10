package xiamomc.timingplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.time.Instant;

public class ScoreboardHandler {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard scb = manager.getNewScoreboard();
    Objective obj = scb.registerNewObjective(
            "Time",
            "dummy",
            "Time"
    );

    public ScoreboardHandler(){
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        long timestamp = Instant.now().getEpochSecond();
        Score unixTimestamp = obj.getScore("UnixTimestamp");
        unixTimestamp.setScore((int) timestamp);
        new BukkitRunnable() {
            @Override
            public void run() {
                long timestamp = Instant.now().getEpochSecond();
                unixTimestamp.setScore((int) timestamp);
            }
        }.runTaskTimer(TimingPlugin.instance, 0, 1);
    }
}
