package xiamomc.timingplugin;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

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
        new BukkitRunnable() {
            @Override
            public void run() {
                long timestamp = Instant.now().getEpochSecond();
                Score unixTimestamp = obj.getScore("UnixTimestamp");
                unixTimestamp.setScore((int) timestamp);
            }
        }.runTaskTimerAsynchronously(TimingPlugin.instance, 0, 1);
    }
}
