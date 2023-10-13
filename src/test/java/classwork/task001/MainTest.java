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
        // Проверяем, что список чисел генерируется корректно
        List<Integer> numbers = RandomNumberModule.generateRandomNumbers(10);
        assertEquals(10, numbers.size());
    }

    @Test
    public void testGenerateRandomNumbersNegativeCount() {
        // Проверяем, что при передаче отрицательного значения возвращается пустой список
        assertThatThrownBy(() -> RandomNumberModule.generateRandomNumbers(-5)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testModulesIntegration() {
        // Генерируем список случайных чисел
        List<Integer> numbers = RandomNumberModule.generateRandomNumbers(10);
        // Ищем максимальное число в списке
        int maxNumber = MaxNumberModule.findMaxNumber(numbers);
        // Проверяем, что максимальное число найдено корректно
//        assertEquals(Collections.max(numbers), maxNumber);
    }

    //5.2.

    @Test
    public void testGetUserName() {
        // Создаем экземпляры классов UserService и UserRepository
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        // Вызываем метод getUserName и проверяем ожидаемый результат
        String result = userService.getUserName(123);
        assertEquals("User 123", result);
    }

    //5.3.
    @Test
    public void testPlaceOrder() {
        // Создаем экземпляры классов OrderService и PaymentService
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        // Вызываем метод placeOrder и проверяем ожидаемый результат
        boolean result = orderService.placeOrder("123", 100.0);
        assertTrue(result);
    }


}