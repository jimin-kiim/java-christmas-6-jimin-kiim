package christmas;

import christmas.domain.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class OrdersTest {
    @DisplayName("음료로만 이루어지면 안된다.")
    @Test
    void createOrdersOnlyWithBeverages() {
        assertThatThrownBy(() -> new Orders("레드와인-1,샴페인-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되면 안된다.")
    @Test
    void createOrdersByDuplicatedMenus() {
        assertThatThrownBy(() -> new Orders("레드와인-1,레드와인-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.")
    @Test
    void createOrdersExceeding20() {
        assertThatThrownBy(() -> new Orders("양송이수프-5,티본스테이크-10,해산물파스타-5,레드와인-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴판에 있는 메뉴만 주분할 수 있습니다.")
    @Test
    void createOrdersNotInMenu() {
        assertThatThrownBy(() -> new Orders("감자수프-5,해산물파스타-5,레드와인-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수는 1이상의 숫자만 가능합니다. ")
    @Test
    void createOrdersLessThan1() {
        assertThatThrownBy(() -> new Orders("양송이수프-0,해산물파스타-5,레드와인-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}