import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netologi.services.VacationService;

public class VacationServiceTest {
    @Test
    public void shouldCalcVacations() {

        VacationService service = new VacationService();
        int expected = 3;
        int actual = service.calculate(10_000, 3000, 20_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalcVacation() {
        int income = 10_000;
        int expenses = 3_000;
        int threshold = 20_000;

        VacationService service = new VacationService();
        int expected = 3;
        int actual = service.calculate(income, expenses, threshold);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/vacation.csv")
    public void shouldCalcMonth(int expected, int income, int expenses, int threshold) {

        VacationService service = new VacationService();
        int actual = service.calculate(income, expenses, threshold);

        Assertions.assertEquals(expected, actual);
    }
}

