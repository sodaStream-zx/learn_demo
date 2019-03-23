package pri.zxx.learndemo.threademo.threadOps.threadmoniter.threadmoniterImp;


import pri.zxx.learndemo.threademo.threadOps.threadmoniter.IThreadmoniter.Observable;
import pri.zxx.learndemo.threademo.threadOps.threadmoniter.IThreadmoniter.Task;
import pri.zxx.learndemo.threademo.threadOps.threadmoniter.IThreadmoniter.TaskLifecycle;

import java.util.concurrent.TimeUnit;

/**
 * @author 一杯咖啡
 * @desc 线程监视器实现
 * @createTime 2018-11-20-17:15
 */
public class ObservableThreadApp<T> extends Thread implements Observable {
    //任务生命周期 不同阶段执行逻辑
    private final TaskLifecycle<T> lifecycle;
    //任务执行单元 相当于Runnable
    private final Task<T> task;
    //线程周期状态
    private Cycle cycle;

    //默认生命周期监视，do nothing；任务执行单元
    public ObservableThreadApp(Task<T> task) throws IllegalAccessException {
        this(new TaskLifecycle.EmptyLifecycle<>(), task);
    }

    //自定义生命周期监视；任务执行单元
    public ObservableThreadApp(TaskLifecycle<T> lifecycle, Task<T> task) throws IllegalAccessException {
        if (null == task) {
            throw new IllegalAccessException("the task is required");
        }
        this.lifecycle = lifecycle;
        this.task = task;
    }

    //自定义生命周期监视；任务执行单元；线程名
    public ObservableThreadApp(TaskLifecycle<T> lifecycle, Task<T> task, String tName) throws IllegalAccessException {
        super(tName);
        if (null == task) {
            throw new IllegalAccessException("the task is required");
        }
        this.lifecycle = lifecycle;
        this.task = task;
    }

    //通知线程执行单元
    @Override
    public final void run() {

        Thread stack = new Thread(() -> {
            while (!this.isInterrupted()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.update(Cycle.STACK, null, null);
            }
        });
        stack.setDaemon(true);
        stack.start();
        this.update(Cycle.STARTED, null, null);
        try {
            this.update(Cycle.RUNNING, null, null);
            T result = this.task.call();
            this.update(Cycle.DONE, result, null);
        } catch (Exception e) {
            this.update(Cycle.ERROR, null, e);
        }
    }

    //通知线程监视对象
    private void update(Cycle cycle, T result, Exception e) {
        if (null == lifecycle) {
            return;
        }
        try {
            switch (cycle) {
                case RUNNING:
                    this.lifecycle.onStart(currentThread());
                    break;
                case STARTED:
                    this.lifecycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.lifecycle.onFinish(currentThread(), result);
                    break;
                case ERROR:
                    this.lifecycle.onError(currentThread(), e);
                    break;
                case STACK:
                    this.lifecycle.onStack(currentThread());
                    break;
            }
        } catch (Exception ex) {
            this.lifecycle.onError(currentThread(), ex);
        }
    }

    @Override
    public void startOb() {
        this.start();
    }

    @Override
    public void interruptOb() {
        this.interrupt();
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }
}
