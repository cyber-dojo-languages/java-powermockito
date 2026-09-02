// Part of the workload the AOT caches are recorded from. It has to exist before
// any learner's kata does, so what the caches hold are the compiler's classes,
// JUnit's and PowerMock's rather than any kata's, and they speed up whatever a
// learner writes.
//
// It reaches a static method on a final class, because that is the thing
// PowerMock exists to stand in for and the reason a kata here is slow: rewriting
// a class to make its statics mockable is what loads javassist and PowerMock's
// own classloader.
public final class Greeter {

    public static String greeting() {
        return "hello";
    }
}
