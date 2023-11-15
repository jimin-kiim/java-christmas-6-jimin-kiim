package christmas;

import christmas.domain.Orders;
import christmas.domain.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class VisitDateTest {
    @DisplayName("31이하의 숫자여야 한다.")
    @Test
    void createVisitDateGreaterThan31() {
        assertThatThrownBy(() -> new Orders("35"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1이상의 숫자여야 한다.")
    @Test
    void createVisitDateLessThan1() {
        assertThatThrownBy(() -> new Orders("-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자여야 한다.")
    @Test
    void createVisitDateWithNonNumber_1() {
        assertThatThrownBy(() -> new VisitDate("1a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자여야 한다.")
    @Test
    void createVisitDateWithNonNumber_2() {
        assertThatThrownBy(() -> new VisitDate("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자여야 한다.")
    @Test
    void createVisitDateWithNonNumber_3() {
        assertThatThrownBy(() -> new VisitDate("abc1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
