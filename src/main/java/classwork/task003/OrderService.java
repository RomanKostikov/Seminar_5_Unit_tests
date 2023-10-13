package classwork.task003;

public class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean placeOrder(String orderId, double amount) {
        // Заказ принимается, только если платеж успешно обработан
        return paymentService.processPayment(orderId, amount);
    }
}
