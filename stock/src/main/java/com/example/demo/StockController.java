package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	@Autowired
	private StockRepository stockRepository;
	
	@GetMapping("/stockAdd")
	public Stock stock(@RequestParam(value="ticker") String ticker,
			@RequestParam(value="price") Double price){
		
		Stock stock= new Stock(ticker,price);
		Stock savedStock = stockRepository.save(stock);
		System.out.println(savedStock.toString());
		return savedStock;
	}
	
	@GetMapping("/stock")
	public Stock stock(@RequestParam(value="ticker") String ticker){
		
		System.out.println(ticker);
		Stock getStock = stockRepository.findOne(ticker);
		return getStock;
	}
}
