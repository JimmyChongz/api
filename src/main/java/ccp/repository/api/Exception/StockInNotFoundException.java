package ccp.repository.api.Exception;

public class StockInNotFoundException extends RuntimeException {
    public StockInNotFoundException(Long id) {
        super("StockIn not found with id: " + id);
    }
}