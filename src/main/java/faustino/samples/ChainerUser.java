package faustino.samples;

public class ChainerUser {

    public void dummyMethod() {

    }


    public Chainer getFirstPartialChain() {
        return Chainer.create()
                .with("step1", this::dummyMethod)
                .with("step2", this::dummyMethod);
    }

    public Chainer getSecondPartialChain() {
        return Chainer.create()
                .with("step3", this::dummyMethod)
                .with("step4", this::dummyMethod);
    }
}
