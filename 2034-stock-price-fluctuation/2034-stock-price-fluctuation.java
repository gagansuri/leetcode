class StockPrice {
    private Map<Integer,Integer> prices;
    private int currentTS = - 1;
    private TreeMap<Integer,Integer> pricesCount;

    
    public StockPrice() {
        prices = new HashMap<>();
        pricesCount = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        // if the timestamp exists before get its price and reduce the count from pricesCount
        if(prices.containsKey(timestamp)) {
            int previousPrice = prices.get(timestamp);
            pricesCount.put(previousPrice, pricesCount.get(previousPrice) - 1);    
            if(pricesCount.get(previousPrice) == 0) pricesCount.remove(previousPrice);
        }
        prices.put(timestamp,price);
        pricesCount.put(price, pricesCount.getOrDefault(price,0)+1);
        if(timestamp > this.currentTS) {
            this.currentTS = timestamp;
        }
        
    }
    
    public int current() {
        return prices.get(this.currentTS);
    }
    
    public int maximum() {
        //Comparator.naturalOrder()
        //return prices.values().stream().max(Comparator.naturalOrder()).get();
        return pricesCount.lastEntry().getKey();
    }
    
    public int minimum() {
        //return  prices.values().stream().min(Comparator.naturalOrder()).get();
        return pricesCount.firstEntry().getKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */