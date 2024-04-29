package ccp.repository.api.Exception;

public class StockOutNotFoundException extends RuntimeException {
    public StockOutNotFoundException(Long id) {
        super("StockOut not found with id: " + id);
    }
}