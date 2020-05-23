class StockSpanner {

    private List<Integer> prices;
    private Stack<Integer> s;
    private int day;

    public StockSpanner() {
        this.prices = new ArrayList();
        this.s = new Stack();
        s.push(0);
        day = 0;
    }

    public int next(int price) {

        int span = 1;
        prices.add(price);
        while (!s.isEmpty() && prices.get(s.peek()) <= price) {
            s.pop();
        }
        if (s.isEmpty())
            span = day + 1;
        else
            span = day - s.peek();

        s.push(day);
        day++;

        return span;

    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner(); int param_1 = obj.next(price);
 */