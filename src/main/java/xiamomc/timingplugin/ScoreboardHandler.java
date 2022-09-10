package xiamomc.timingplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class ScoreboardHandler {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard scb = manager.getMainScoreboard();
    Objective obj = scb.getObjective("xiamoTime");

    Instant baseTime;

    public ScoreboardHandler(){
        Calendar cal = Calendar.getInstance();
        cal.set(2022, Calendar.JANUARY, 1, 0, 0, 0);
        baseTime = cal.getTime().toInstant();

        if (scb.getObjective("xiamoTime") == null)
            obj = scb.registerNewObjective("xiamoTime", "dummy", Component.text("RealTime"));

        //obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        long timestamp = Instant.now().getEpochSecond();
        Score unixTimestamp = obj.getScore("UnixTimestamp");
        unixTimestamp.setScore((int) timestamp);
        new BukkitRunnable() {
            @Override
            public void run() {
                long timestamp = Instant.now().getEpochSecond() - baseTime.getEpochSecond();
                unixTimestamp.setScore((int) timestamp * 20);
            }
        }.runTaskTimer(TimingPlugin.instance, 0, 1);
    }
}
