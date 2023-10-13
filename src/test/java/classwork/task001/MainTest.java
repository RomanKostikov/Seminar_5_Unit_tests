package classwork.task001;

import classwork.task002.UserRepository;
import classwork.task002.UserService;
import classwork.task003.OrderService;
import classwork.task003.PaymentService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    //5.1.

    @Test
    public void testGenerateRandomNumbers() {
        // ���������, ��� ������ ����� ������������ ���������
        List<Integer> numbers = RandomNumberModule.generateRandomNumbers(10);
        assertEquals(10, numbers.size());
    }

    @Test
    public void testGenerateRandomNumbersNegativeCount() {
        // ���������, ��� ��� �������� �������������� �������� ������������ ������ ������
        assertThatThrownBy(() -> RandomNumberModule.generateRandomNumbers(-5)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testModulesIntegration() {
        // ���������� ������ ��������� �����
        List<Integer> numbers = RandomNumberModule.generateRandomNumbers(10);
        // ���� ������������ ����� � ������
        int maxNumber = MaxNumberModule.findMaxNumber(numbers);
        // ���������, ��� ������������ ����� ������� ���������
//        assertEquals(Collections.max(numbers), maxNumber);
    }

    //5.2.

    @Test
    public void testGetUserName() {
        // ������� ���������� ������� UserService � UserRepository
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        // �������� ����� getUserName � ��������� ��������� ���������
        String result = userService.getUserName(123);
        assertEquals("User 123", result);
    }

    //5.3.
    @Test
    public void testPlaceOrder() {
        // ������� ���������� ������� OrderService � PaymentService
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        // �������� ����� placeOrder � ��������� ��������� ���������
        boolean result = orderService.placeOrder("123", 100.0);
        assertTrue(result);
    }


}