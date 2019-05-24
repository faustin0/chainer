package it.unipol.buttami;

import it.unipol.buttami.clients.SonarApi;

public class ExecutorImpl implements Executor {

    private final SonarApi sonarApi;

    public ExecutorImpl(SonarApi sonarApi) {
        this.sonarApi = sonarApi;
    }

    @Override
    public void execute(Command command) {
        System.out.println("executor running command");
        command.run(this.sonarApi);
        System.out.println("end");
    }
}
