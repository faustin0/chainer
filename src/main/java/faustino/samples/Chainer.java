package faustino.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Chainer {

    private List<Runnable> commands;
    private BiConsumer<String, Runnable> executor;

    private Chainer() {
        this.commands = new ArrayList<>();
    }

    public static Chainer create() {
        return new Chainer();
    }

    public Chainer with(String description, Runnable toExecute) {
        commands.add(() -> executor.accept(description, toExecute));
        return this;
    }


    public void execute() {
        this.commands.forEach(Runnable::run);
    }

    public Chainer using(BiConsumer<String, Runnable> executor) {
        this.executor = executor;
        return this;
    }
}
