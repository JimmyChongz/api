package ccp.repository.api.controller;

import ccp.repository.api.entities.StockIn;
import ccp.repository.api.repositories.StockInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ccp.repository.api.Exception.StockInNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/stockIn")
public class StockInController {
    @Autowired
    private StockInRepository stockInRepository;

    // 會取入庫全紀錄
    @GetMapping("/stockIn")
    public List<StockIn> getAllStockIn() {
        return stockInRepository.findAll();
    }

    // 創建入庫紀錄
    @PostMapping("/stockIn")
    public StockIn createStockIn(@RequestBody StockIn stockIn) {
        return stockInRepository.save(stockIn);
    }

    // 獲取入庫紀錄
    @GetMapping("/stockIn/{id}")
    public Optional<StockIn> getStockIn(@PathVariable Long id) {
        return stockInRepository.findById(id);
    }

    // 更新入庫紀錄
    @PutMapping("/stockIn/{id}")
    public StockIn updateStockIn(@PathVariable Long id, @RequestBody StockIn stockInData) {
        Optional<StockIn> stockInOptional = stockInRepository.findById(id);
        if (stockInOptional.isPresent()) {
            StockIn stockIn = stockInOptional.get();
            stockIn.setStockDate(stockInData.getStockDate());
            stockIn.setDemandPerson(stockInData.getDemandPerson());
            stockIn.setDepartment(stockInData.getDepartment());
            stockIn.setQuantity(stockInData.getQuantity());
            return stockInRepository.save(stockIn);
        } else {
            throw new StockInNotFoundException(id);
        }
    }

    // 刪除入庫紀錄
    @DeleteMapping("/stockIn/{id}")
    public void deleteStockIn(@PathVariable Long id) {
        stockInRepository.deleteById(id);
    }
}
