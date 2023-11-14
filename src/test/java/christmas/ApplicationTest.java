package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 할인_전_총_주문_금액() {
        assertSimpleTest(() -> {
            run("3", "타파스-1,제로콜라-1");
            assertThat(output()).contains(
                    "8,500원"
            );
        });
    }

    @Test
    void 할인_전_총_주문_금액_2() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "142,000원"
            );
        });
    }

    @Test
    void 증정_이벤트_해당() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "샴페인 1개"
            );
        });
    }

    @Test
    void 증정_이벤트_해당_없음() {
        assertSimpleTest(() -> {
            run("3", "타파스-1,제로콜라-1");
            assertThat(output()).contains(
                    "없음"
            );
        });
    }

    @Test
    void 디데이_이벤트_해당() {
        assertSimpleTest(() -> {
            run("25", "시저샐러드-1,제로콜라-1");
            assertThat(output()).contains(
                    "크리스마스 디데이 할인: -3,400원"
            );
        });
    }

    @Test
    void 디데이_이벤트_해당_없음() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).doesNotContain(
                    "크리스마스 디데이 할인"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_예외_테스트_범위_31_초과() {
        assertSimpleTest(() -> {
            runException("32");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_예외_테스트_범위_1_미만() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트_형식() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트_수량() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-0");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트_메뉴_오류() {
        assertSimpleTest(() -> {
            runException("3", "제로펩시");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트_형식_순서() {
        assertSimpleTest(() -> {
            runException("3", "3-제로펩시");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트_중복() {
        assertSimpleTest(() -> {
            runException("3", "제로펩시-3,제로펩시-4");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
