package faustino.samples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class ChainerUserTest {

    @Test
    void shouldReturnChainWithStep() {
        ChainerUser chainerUser = Mockito.spy(new ChainerUser());
        Chainer partialChain = chainerUser.getFirstPartialChain();

        partialChain
                .using(new ExecutorImpl())
                .execute();

        Mockito.verify(chainerUser, Mockito.times(2)).dummyMethod();
    }

    @Test
    void shouldReturnCombinedChain() {
        ChainerUser chainerUser = Mockito.spy(new ChainerUser());
        Chainer firstChain = chainerUser.getFirstPartialChain();
        Chainer secondChain = chainerUser.getSecondPartialChain();
        ExecutorImpl executor = Mockito.spy(new ExecutorImpl());

        Chainer.create()
                .using(executor)
                .concat(firstChain, secondChain)
                .execute();

        Mockito.verify(chainerUser, Mockito.times(4)).dummyMethod();
        Mockito.verify(executor, Mockito.times(4)).accept(anyString(), any(Runnable.class));
    }
}