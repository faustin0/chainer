package faustino.samples;

import java.util.function.BiConsumer;

public class ExecutorImpl implements BiConsumer<String, Runnable> {


    @Override
    public void accept(String s, Runnable runnable) {
        System.out.println("executor starting command " + s);
        runnable.run();
        System.out.println("executor executed command " + s);
    }
}
