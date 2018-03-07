import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import static org.powermock.api.mockito.PowerMockito.*;
import org.mockito.stubbing.Answer;
import org.mockito.invocation.InvocationOnMock;
import static org.mockito.Matchers.anyString;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DiskLogger.class)
public class HikerTest {

    @Test
    public void life_the_universe_and_everything() {
        FakeLogger fakeLog = new FakeLogger();
        use(fakeLog);

        int expected = 42;
        int actual = new Hiker().answer();
        assertEquals(expected, actual);

        assertTrue(fakeLog.endsWith("The answer is 6 * 7"));
    }

    private void use(FakeLogger fake) {
        mockStatic(DiskLogger.class);
        DiskLogger mocked = mock(DiskLogger.class);
        when(DiskLogger.getInstance()).thenReturn(mocked);

        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
              String line = (String)invocation.getArguments()[0];
              fake.log(line); // <====
              return null;
            }
        }).when(mocked).log(anyString());  // <====
    }
}
