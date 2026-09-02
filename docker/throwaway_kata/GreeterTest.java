// The test half of the workload the AOT caches are recorded from. Mocking a
// static method is what pulls PowerMock's runner, its classloader and javassist
// into the cache alongside Mockito's and JUnit's own classes.
//
// It passes, because a JVM writes a cache when it exits of its own accord and a
// green run is the simplest way to be sure of that.
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("jdk.internal.reflect.*")
@PrepareForTest(Greeter.class)
public class GreeterTest {

    @Test
    public void greeting_can_be_stood_in_for() throws Exception {
        mockStatic(Greeter.class);
        when(Greeter.greeting()).thenReturn("goodbye");
        assertEquals("goodbye", Greeter.greeting());
    }
}
