package it.unipol.buttami;

import java.util.ArrayList;
import java.util.List;

public class Chainer {

    List<Command> commands;
    private Executor executor;

    private Chainer() {
        this.commands = new ArrayList<>();
    }

    public static Chainer create() {
        return new Chainer();
    }


    public Chainer with(Command command) {
        commands.add(command);
        return this;
    }

    public void execute() {
        this.commands.forEach(this.executor::execute);
    }

    public Chainer using(Executor executor) {
        this.executor = executor;
        return this;
    }
}
