package faustino.samples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chainer {

    private List<Runnable> commands;
    private BiConsumer<String, Runnable> executor;

    private Chainer(List<Runnable> commands) {
        this.commands = commands;
        this.executor = this::defaultExecutor;
    }

    public Chainer concat(Chainer c1, Chainer c2) {
        c1.executor = this.executor;
        c2.executor = this.executor;
        List<Runnable> commands = Stream.of(
                c1.commands,
                c2.commands
        ).flatMap(Collection::stream).collect(Collectors.toList());

        this.commands = commands;
        return this;
    }

    public static Chainer create() {
        return new Chainer(new ArrayList<>());
    }

    public Chainer with(String description, Runnable toExecute) {
        commands.add(() -> this.executor.accept(description, toExecute));
        return this;
    }


    public void execute() {
        this.commands.forEach(Runnable::run);
    }

    public Chainer using(BiConsumer<String, Runnable> executor) {
        this.executor = executor;
        return this;
    }

    private void defaultExecutor(String s, Runnable r) {
        r.run();
    }
}
