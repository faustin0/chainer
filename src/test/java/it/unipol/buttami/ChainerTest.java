package it.unipol.buttami;

import it.unipol.buttami.clients.SonarApi;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ChainerTest {

    @Test
    public void shouldCreateChainer() {
        Executor executor = Mockito.mock(Executor.class);
        Chainer chainer = Chainer.create().using(executor);
        Assert.assertNotNull(chainer);
    }

    @Test
    public void shouldRegister_oneCommand() {
        Command command = new CommandImpl();
        Chainer chainer = Chainer.create().with(command);
        Assert.assertNotNull(chainer);
    }

    @Test
    public void shouldExecuteRegisteredCommand() {
        Command command = Mockito.mock(Command.class);

        Chainer.create()
                .using(new ExecutorImpl(Mockito.mock(SonarApi.class)))
                .with(command)
                .execute();

        Mockito.verify(command).run();
    }

    @Test
    public void shouldExecute_twoRegisteredCommand() {
        Command command1 = Mockito.mock(Command.class);
        Command command2 = Mockito.mock(Command.class);

        Chainer.create()
                .using(new ExecutorImpl(Mockito.mock(SonarApi.class)))
                .with(command1)
                .with(command2)
                .execute();

        Mockito.verify(command1).run();
        Mockito.verify(command2).run();
    }


}
