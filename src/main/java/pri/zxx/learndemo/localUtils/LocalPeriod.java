package pri.zxx.learndemo.localUtils;

import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 选择区间的策略
 */
interface PeriodStrategy {
    LocalPeriod compute();
}

/**
 * <p>起止日期</p>
 *
 * @author <a href="mailto:xxbjiy@163.com">huangxl</a>
 * @since 2020/1/10 17:04
 */
public class LocalPeriod {
    public LocalDateTime start;
    public LocalDateTime end;
    /**
     * 同比的开始日期
     */
    public LocalDateTime pre_start;
    /**
     * 同比的结束日期
     */
    public LocalDateTime pre_end;

    public LocalPeriod() {
    }

    public LocalPeriod(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalPeriod(LocalDateTime start, LocalDateTime end, LocalDateTime pre_start, LocalDateTime pre_end) {
        this.start = start;
        this.end = end;
        this.pre_start = pre_start;
        this.pre_end = pre_end;
    }

    public static void main(String[] args) {
        System.out.println(getThisYear());
        LocalPeriod localPeriod9 = LocalPeriod.getPeriod("2020-04-14 20:22:52", "2020-04-20 20:22:52");
        System.out.println("custom:" + localPeriod9);
        System.out.println(localPeriod9.theStart() + "--" + localPeriod9.theEnd() + "--" + localPeriod9.thePre_start() + "--" + localPeriod9.thePre_end());
        System.out.println("-----------------------------");
        System.out.println("custom intval:" + localPeriod9.getInterval(1));
        LocalPeriod localPeriod = LocalPeriod.getPeriod(0);
        LocalPeriod localPeriod1 = LocalPeriod.getPeriod(1);
        LocalPeriod localPeriod2 = LocalPeriod.getPeriod(2);
        LocalPeriod localPeriod3 = LocalPeriod.getPeriod(3);
        LocalPeriod localPeriod4 = LocalPeriod.getPeriod(4);
        LocalPeriod localPeriod5 = LocalPeriod.getPeriod(5);
        LocalPeriod localPeriod6 = LocalPeriod.getPeriod(6);
        LocalPeriod localPeriod7 = LocalPeriod.getPeriod(7);
        System.out.println("YESTERDAY：" + localPeriod);
        System.out.println("RECENT_7_DAYS：" + localPeriod1);
        System.out.println("THIS_MONTH：" + localPeriod2);
        System.out.println("LAST_MONTH：" + localPeriod3);
        System.out.println("THIS_WEEK：" + localPeriod4);
        System.out.println("THIS_YEAR:" + localPeriod5);
        System.out.println("LAST_WEEK:" + localPeriod6);
        System.out.println("TODAY:" + localPeriod7);
    }

    public static LocalPeriod getPeriod(int periodType) {
        PeriodStrategy strategy = PeriodStrategyFactory.Holder.singleton.getStrategy(periodType);
        return strategy.compute();
    }

    public static LocalPeriod getPeriod(PeriodType type) {
        return getPeriod(type.ordinal());
    }

    public static LocalPeriod getPeriod(String start, String end) {
        LocalPeriod localPeriod = new LocalPeriod();
        if (StringUtils.isNotBlank(start)) {
            localPeriod.start = LocalDateUtil.dateTimeParse(start);
        }
        if (StringUtils.isNotBlank(end)) {
            localPeriod.end = LocalDateUtil.dateTimeParse(end);
        }
        long days = Duration.between(localPeriod.start, localPeriod.end).toDays();
        LocalDateTime pre_start = localPeriod.start.minusDays(days);
        localPeriod.pre_end = localPeriod.start;
        localPeriod.pre_start = pre_start;
        return localPeriod;
    }

    /**
     * 获得当前年份
     *
     * @return
     */
    public static Integer getThisYear() {
        return LocalDate.now().getYear();
    }

    /**
     * 本月初到今日
     */
    public static LocalPeriod getThisMonth() {
        LocalPeriod localPeriod = new LocalPeriod();
        localPeriod.end = LocalDateTime.now();
        localPeriod.start = LocalDateTime.of(LocalDate.of(localPeriod.end.getYear(), localPeriod.end.getMonth(), 1), LocalTime.MIN);
        return localPeriod;
    }

    @Override
    public String toString() {
        return "Period{" +
                "start=" + LocalDateUtil.formatter(start) +
                ", end=" + LocalDateUtil.formatter(end) +
                ", pre_start=" + LocalDateUtil.formatter(pre_start) +
                ", pre_end=" + LocalDateUtil.formatter(pre_end) +
                '}';
    }

    public Date theStart() {
        return LocalDateUtil.transferToDate(start);
    }

    public Date theEnd() {
        return LocalDateUtil.transferToDate(end);
    }

    public Date thePre_start() {
        return LocalDateUtil.transferToDate(pre_start);
    }

    public Date thePre_end() {
        return LocalDateUtil.transferToDate(pre_end);
    }

    public long getInterval(Integer tip) {
        Duration between = Duration.between(start, end);
        switch (tip) {
            case 1:
                return between.toMinutes();
            case 2:
                return between.toHours();
            case 3:
                return between.toDays();
            default:
                return between.toMillis();
        }
    }

    public enum PeriodType {
        YESTERDAY, RECENT_7_DAYS, THIS_MONTH, LAST_MONTH, CUSTOM, THIS_WEEK, THIS_YEAR, LAST_WEEK, TODAY
    }
}

abstract class AbstractPeriodStrategy implements PeriodStrategy {
    Date start;
    Date end;
    Date pre_start;
    Date pre_end;
}

class YesterdayStrategy extends AbstractPeriodStrategy {
    @Override
    public LocalPeriod compute() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDateTime yesterday_start = LocalDateTime.of(yesterday, LocalTime.MIN);
        LocalDateTime yesterday_end = LocalDateTime.of(yesterday, LocalTime.MAX);
        LocalDate beforeYesterday = yesterday.minusDays(1);
        LocalDateTime beforeYesterday_start = LocalDateTime.of(beforeYesterday, LocalTime.MIN);
        return new LocalPeriod(yesterday_start, yesterday_end, beforeYesterday_start, yesterday_end);
    }
}

class RecentSevenDaysStrategy extends AbstractPeriodStrategy {

    @Override
    public LocalPeriod compute() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime beforeSeven = now.minusDays(7);
        LocalDateTime beforeFourth = now.minusDays(14);
        return new LocalPeriod(beforeSeven, now, beforeFourth, beforeSeven);
    }
}

class ThisMonthStrategy extends AbstractPeriodStrategy {

    @Override
    public LocalPeriod compute() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime beforeMonth = now.minusMonths(1);
        LocalDateTime beforeTwoMonth = now.minusMonths(2);
        return new LocalPeriod(beforeMonth, now, beforeTwoMonth, beforeMonth);
    }
}

class LastMonthStrategy extends AbstractPeriodStrategy {

    @Override
    public LocalPeriod compute() {
        LocalDateTime oneBefore = LocalDateTime.now().minusMonths(1);
        LocalDateTime beforeMonth = oneBefore.minusMonths(1);
        LocalDateTime beforeTwoMonth = oneBefore.minusMonths(2);
        return new LocalPeriod(beforeMonth, oneBefore, beforeTwoMonth, beforeMonth);
    }
}


class ThisWeekStrategy extends AbstractPeriodStrategy {

    @Override
    public LocalPeriod compute() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekBefore = now.minusWeeks(1);
        LocalDateTime twoWeekBefore = now.minusWeeks(2);
        return new LocalPeriod(oneWeekBefore, now, twoWeekBefore, oneWeekBefore);
    }
}

class LastWeekStrategy extends AbstractPeriodStrategy {
    @Override
    public LocalPeriod compute() {
        LocalDateTime now = LocalDateTime.now().minusWeeks(1);
        LocalDateTime oneWeekBefore = now.minusWeeks(1);
        LocalDateTime twoWeekBefore = now.minusWeeks(2);
        return new LocalPeriod(oneWeekBefore, now, twoWeekBefore, oneWeekBefore);
    }
}

class ThisYearStrategy extends AbstractPeriodStrategy {

    @Override
    public LocalPeriod compute() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneYearBefore = now.minusYears(1);
        LocalDateTime twoYearBefore = now.minusYears(2);
        return new LocalPeriod(oneYearBefore, now, twoYearBefore, oneYearBefore);
    }
}

class TodayStrategy extends AbstractPeriodStrategy {

    @Override
    public LocalPeriod compute() {
        LocalDate today = LocalDate.now();
        LocalDateTime today_start = LocalDateTime.of(today, LocalTime.MIN);
        LocalDateTime today_end = LocalDateTime.of(today, LocalTime.MAX);
        LocalDate yesterday = today.minusDays(1);
        LocalDateTime yesterday_start = LocalDateTime.of(yesterday, LocalTime.MIN);
        return new LocalPeriod(today_start, today_end, yesterday_start, today_start);
    }
}

class CustomStrategy extends AbstractPeriodStrategy {
    @Override
    public LocalPeriod compute() {
        return new LocalPeriod();
    }
}

class PeriodStrategyFactory {
    static Map<Integer, PeriodStrategy> strategyMap;

    private PeriodStrategyFactory() {
        strategyMap = new HashMap<>(7);
        strategyMap.put(LocalPeriod.PeriodType.YESTERDAY.ordinal(), new YesterdayStrategy());
        strategyMap.put(LocalPeriod.PeriodType.RECENT_7_DAYS.ordinal(), new RecentSevenDaysStrategy());
        strategyMap.put(LocalPeriod.PeriodType.THIS_MONTH.ordinal(), new ThisMonthStrategy());
        strategyMap.put(LocalPeriod.PeriodType.LAST_MONTH.ordinal(), new LastMonthStrategy());
        strategyMap.put(LocalPeriod.PeriodType.CUSTOM.ordinal(), new CustomStrategy());
        strategyMap.put(LocalPeriod.PeriodType.THIS_WEEK.ordinal(), new ThisWeekStrategy());
        strategyMap.put(LocalPeriod.PeriodType.THIS_YEAR.ordinal(), new ThisYearStrategy());
        strategyMap.put(LocalPeriod.PeriodType.LAST_WEEK.ordinal(), new LastWeekStrategy());
        strategyMap.put(LocalPeriod.PeriodType.TODAY.ordinal(), new TodayStrategy());
    }

    PeriodStrategy getStrategy(Integer type) {
        PeriodStrategy strategy = strategyMap.get(type);
        if (strategy == null) {
            System.out.println("wrong");
        }
        return strategy;
    }

    static class Holder {
        public static PeriodStrategyFactory singleton = new PeriodStrategyFactory();
    }
}