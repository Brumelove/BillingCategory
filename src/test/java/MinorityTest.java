import net.telnet.afrinic.Minority;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MinorityTest {
    Minority minority = new Minority();
    @Test
    public void whenReadWithBufferedReader_thenCorrect()
            throws IOException {
        File file = new File("/Users/love.brume/IdeaProjects/Size.net.afrinic/src/main/java/net/telnet/afrinic/delegated-afrinic-extended-latestnet/telnet/afrinic");

        minority.readFile(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        reader.close();




    }
}
