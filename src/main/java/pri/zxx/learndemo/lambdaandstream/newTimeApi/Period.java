package pri.zxx.learndemo.lambdaandstream.newTimeApi;

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
    Period compute();

    default Period custom(String start, String end) {
        return new Period();
    }
}

/**
 * <p>起止日期</p>
 *
 * @author <a href="mailto:xxbjiy@163.com">huangxl</a>
 * @since 2020/1/10 17:04
 */
public class Period {
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

    public Period() {
    }

    public Period(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public Period(LocalDateTime start, LocalDateTime end, LocalDateTime pre_start, LocalDateTime pre_end) {
        this.start = start;
        this.end = end;
        this.pre_start = pre_start;
        this.pre_end = pre_end;
    }

    public static void main(String[] args) {
        System.out.println(getThisYear());
        Period period9 = Period.getPeriod("2020-04-14 20:22:52", "2020-04-20 20:22:52");
        System.out.println("custom:" + period9);
        System.out.println("custom intval:" + period9.getInterval());
        Period period = Period.getPeriod(0);
        Period period1 = Period.getPeriod(1);
        Period period2 = Period.getPeriod(2);
        Period period3 = Period.getPeriod(3);
        Period period4 = Period.getPeriod(4);
        Period period5 = Period.getPeriod(5);
        Period period6 = Period.getPeriod(6);
        Period period7 = Period.getPeriod(7);
        System.out.println("YESTERDAY：" + period);
        System.out.println("RECENT_7_DAYS：" + period1);
        System.out.println("THIS_MONTH：" + period2);
        System.out.println("LAST_MONTH：" + period3);
        System.out.println("THIS_WEEK：" + period4);
        System.out.println("THIS_YEAR:" + period5);
        System.out.println("LAST_WEEK:" + period6);
        System.out.println("TODAY:" + period7);
    }

    public static Period getPeriod(int periodType) {
        PeriodStrategy strategy = PeriodStrategyFactory.Holder.singleton.getStrategy(periodType);
        return strategy.compute();
    }

    public static Period getPeriod(PeriodType type) {
        return getPeriod(type.ordinal());
    }

    public static Period getPeriod(String start, String end) {
        Period period = new Period();
        if (StringUtils.isNotBlank(start)) {
            period.start = DateUtil.dateTimeParse(start);
        }
        if (StringUtils.isNotBlank(end)) {
            period.end = DateUtil.dateTimeParse(end);
        }
        long days = Duration.between(period.start, period.end).toDays();
        LocalDateTime pre_start = period.start.minusDays(days);
        period.pre_end = period.start;
        period.pre_start = pre_start;
        return period;
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
    public static Period getThisMonth() {
        Period period = new Period();
        period.end = LocalDateTime.now();
        period.start = LocalDateTime.of(LocalDate.of(period.end.getYear(), period.end.getMonth(), 1), LocalTime.MIN);
        return period;
    }

    @Override
    public String toString() {
        return "Period{" +
                "start=" + DateUtil.formatter(start) +
                ", end=" + DateUtil.formatter(end) +
                ", pre_start=" + DateUtil.formatter(pre_start) +
                ", pre_end=" + DateUtil.formatter(pre_end) +
                '}';
    }

    public Date theStart() {
        return DateUtil.transferToDate(start);
    }

    public Date theEnd() {
        return DateUtil.transferToDate(end);
    }

    public Date thePre_start() {
        return DateUtil.transferToDate(pre_start);
    }

    public Date thePre_end() {
        return DateUtil.transferToDate(pre_end);
    }

    public long getInterval() {
        return Duration.between(start, end).toMillis();
    }

    public enum PeriodType {
        YESTERDAY, RECENT_7_DAYS, THIS_MONTH, LAST_MONTH, THIS_WEEK, THIS_YEAR, LAST_WEEK, TODAY
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
    public Period compute() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDateTime yesterday_start = LocalDateTime.of(yesterday, LocalTime.MIN);
        LocalDateTime yesterday_end = LocalDateTime.of(yesterday, LocalTime.MAX);
        LocalDate beforeYesterday = yesterday.minusDays(1);
        LocalDateTime beforeYesterday_start = LocalDateTime.of(beforeYesterday, LocalTime.MIN);
        return new Period(yesterday_start, yesterday_end, beforeYesterday_start, yesterday_end);
    }
}

class RecentSevenDaysStrategy extends AbstractPeriodStrategy {

    @Override
    public Period compute() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime beforeSeven = now.minusDays(7);
        LocalDateTime beforeFourth = now.minusDays(14);
        return new Period(beforeSeven, now, beforeFourth, beforeSeven);
    }
}

class ThisMonthStrategy extends AbstractPeriodStrategy {

    @Override
    public Period compute() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime beforeMonth = now.minusMonths(1);
        LocalDateTime beforeTwoMonth = now.minusMonths(2);
        return new Period(beforeMonth, now, beforeTwoMonth, beforeMonth);
    }
}

class LastMonthStrategy extends AbstractPeriodStrategy {

    @Override
    public Period compute() {
        LocalDateTime oneBefore = LocalDateTime.now().minusMonths(1);
        LocalDateTime beforeMonth = oneBefore.minusMonths(1);
        LocalDateTime beforeTwoMonth = oneBefore.minusMonths(2);
        return new Period(beforeMonth, oneBefore, beforeTwoMonth, beforeMonth);
    }
}


class ThisWeekStrategy extends AbstractPeriodStrategy {

    @Override
    public Period compute() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekBefore = now.minusWeeks(1);
        LocalDateTime twoWeekBefore = now.minusWeeks(2);
        return new Period(oneWeekBefore, now, twoWeekBefore, oneWeekBefore);
    }
}

class LastWeekStrategy extends AbstractPeriodStrategy {
    @Override
    public Period compute() {
        LocalDateTime now = LocalDateTime.now().minusWeeks(1);
        LocalDateTime oneWeekBefore = now.minusWeeks(1);
        LocalDateTime twoWeekBefore = now.minusWeeks(2);
        return new Period(oneWeekBefore, now, twoWeekBefore, oneWeekBefore);
    }
}

class ThisYearStrategy extends AbstractPeriodStrategy {

    @Override
    public Period compute() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneYearBefore = now.minusYears(1);
        LocalDateTime twoYearBefore = now.minusYears(2);
        return new Period(oneYearBefore, now, twoYearBefore, oneYearBefore);
    }
}

class TodayStrategy extends AbstractPeriodStrategy {

    @Override
    public Period compute() {
        LocalDate today = LocalDate.now();
        LocalDateTime today_start = LocalDateTime.of(today, LocalTime.MIN);
        LocalDateTime today_end = LocalDateTime.of(today, LocalTime.MAX);
        LocalDate yesterday = today.minusDays(1);
        LocalDateTime yesterday_start = LocalDateTime.of(yesterday, LocalTime.MIN);
        return new Period(today_start, today_end, yesterday_start, today_start);
    }
}

class PeriodStrategyFactory {
    static Map<Integer, PeriodStrategy> strategyMap;

    private PeriodStrategyFactory() {
        strategyMap = new HashMap<>(7);
        strategyMap.put(Period.PeriodType.YESTERDAY.ordinal(), new YesterdayStrategy());
        strategyMap.put(Period.PeriodType.RECENT_7_DAYS.ordinal(), new RecentSevenDaysStrategy());
        strategyMap.put(Period.PeriodType.THIS_MONTH.ordinal(), new ThisMonthStrategy());
        strategyMap.put(Period.PeriodType.LAST_MONTH.ordinal(), new LastMonthStrategy());
        strategyMap.put(Period.PeriodType.THIS_WEEK.ordinal(), new ThisWeekStrategy());
        strategyMap.put(Period.PeriodType.THIS_YEAR.ordinal(), new ThisYearStrategy());
        strategyMap.put(Period.PeriodType.LAST_WEEK.ordinal(), new LastWeekStrategy());
        strategyMap.put(Period.PeriodType.TODAY.ordinal(), new TodayStrategy());
    }

    PeriodStrategy getStrategy(Integer type) {
        PeriodStrategy strategy = strategyMap.get(type);
        if (strategy == null) {
            throw new BusinessException(ResultCode.ILLEGAL_PARAM);
        }
        return strategy;
    }

    static class Holder {
        public static PeriodStrategyFactory singleton = new PeriodStrategyFactory();
    }
}