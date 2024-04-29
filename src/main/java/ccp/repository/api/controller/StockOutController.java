package ccp.repository.api.controller;

import ccp.repository.api.Exception.StockOutNotFoundException;
import ccp.repository.api.entities.StockOut;
import ccp.repository.api.repositories.StockOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/stockOut")
public class StockOutController {
    @Autowired
    private StockOutRepository stockOutRepository;

    // 查看全部
    @GetMapping
    public List<StockOut> getAllStockOut() {
        return stockOutRepository.findAll();
    }

    // 建立出庫紀錄
    @PostMapping
    public StockOut createStockOut(@RequestBody StockOut stockOut) {
        return stockOutRepository.save(stockOut);
    }

    // 獲取特定出庫紀錄
    @GetMapping("/{id}")
    public Optional<StockOut> getStockOut(@PathVariable Long id) {
        return stockOutRepository.findById(id);
    }

    // 更新出庫紀錄
    @PutMapping("/{id}")
    public StockOut updateStockOut(@PathVariable Long id, @RequestBody StockOut stockOutData) {
        Optional<StockOut> stockOutOptional = stockOutRepository.findById(id);
        if (stockOutOptional.isPresent()) {
            StockOut stockOut = stockOutOptional.get();
            stockOut.setStockDate(stockOutData.getStockDate());
            stockOut.setDemandPerson(stockOutData.getDemandPerson());
            stockOut.setDepartment(stockOutData.getDepartment());
            stockOut.setQuantity(stockOutData.getQuantity());
            return stockOutRepository.save(stockOut);
        } else {
            throw new StockOutNotFoundException(id);
        }
    }

    // 刪除出庫紀錄
    @DeleteMapping("/{id}")
    public void deleteStockOut(@PathVariable Long id) {
        stockOutRepository.deleteById(id);
    }
}
