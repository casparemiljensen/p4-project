import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ SymbolTableUnitTests.class, ErrorTests.class, CodeGenerationTest.class })
public class TestSuite {

}
