package it.unipol.buttami;

import it.unipol.buttami.clients.SonarApi;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExecutorImplTest {

    @Test
    public void shouldCreateExecutorImpl(){
        SonarApi sonarApi = Mockito.mock(SonarApi.class);
        ExecutorImpl executor = new ExecutorImpl(sonarApi);
        Assert.assertNotNull(executor);
    }






}