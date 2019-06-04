package faustino.samples;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

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
        Chainer completeChain = chainerUser.getCompleteChain();

        completeChain
                .using(new ExecutorImpl())
                .execute();

        Mockito.verify(chainerUser, Mockito.times(4)).dummyMethod();
    }
}