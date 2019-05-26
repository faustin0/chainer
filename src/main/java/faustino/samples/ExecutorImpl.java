package faustino.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiConsumer;

public class ExecutorImpl implements BiConsumer<String, Runnable> {
    private final Logger log = LoggerFactory.getLogger(ExecutorImpl.class);

    @Override
    public void accept(String s, Runnable runnable) {
        log.info("executor starting command {}", s);
        runnable.run();
        log.info("executor executed command {}", s);
    }
}
