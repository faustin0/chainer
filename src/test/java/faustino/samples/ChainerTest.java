package faustino.samples;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.function.BiConsumer;

import static org.assertj.core.api.Assertions.assertThat;


public class ChainerTest {

    @Test
    public void shouldCreateChainer() {
        BiConsumer executor = Mockito.mock(BiConsumer.class);
        Chainer chainer = Chainer.create().using(executor);
        assertThat(chainer).isNotNull();
    }

    @Test
    public void shouldRegister_oneCommandWithDescription() {
        Runnable toRegister = Mockito.mock(Runnable.class);
        Chainer chainer = Chainer.create()
                .with("my description", toRegister);
        assertThat(chainer).isNotNull();
    }

    @Test
    public void shouldExecuteRegisteredCommand() {
        Runnable toExecute = Mockito.mock(Runnable.class);

        Chainer.create()
                .using(new ExecutorImpl())
                .with("Templates", toExecute)
                .execute();

        Mockito.verify(toExecute).run();
    }

    @Test
    public void shouldExecute_twoRegisteredCommand() {
        Runnable toExecute1 = Mockito.mock(Runnable.class);
        Runnable toExecute2 = Mockito.mock(Runnable.class);

        Chainer.create()
                .using(new ExecutorImpl())
                .with("toExecute1", toExecute1)
                .with("toExecute2", toExecute2)
                .execute();

        Mockito.verify(toExecute1).run();
        Mockito.verify(toExecute2).run();
    }


}
