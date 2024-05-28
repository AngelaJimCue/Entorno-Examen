package junito.mipaquete;

public class Counter {
	private int value = 0;
	private int maxValue = 100_000;
	private String model = "N-COUNTER";
	
	public Counter() {
	}

	public Counter(int maxValue) {
		this.maxValue = maxValue;
	}

	public Counter(int maxValue, String model) {
		this.maxValue = maxValue;
		this.model = model;
	}

	public Counter(Counter contador) {
		this(contador.maxValue, contador.model);
		this.value = contador.value;
		this.maxValue = contador.maxValue;
	}	
		
	
	public int getValue() {
		return value;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public String getModel() {
		return model;
	}

	
	public boolean increment() {
		if(value + 1 <= maxValue ) {
			value++; 
			return true;
		}
		return false;
	}
	
	public boolean increment(int n){
		if(n <= 0) throw new IllegalArgumentException("Tiene que ser mayor de cero");
		long valorLong = (long)value + n;
		if(valorLong > Integer.MAX_VALUE) {
			value = maxValue;
			return false; 
		}
		if(value + n <= maxValue) {		
			value += n;
			return true;
		}
		value = maxValue;
		return false;
	}
	
	public boolean reset() {
		if(value == maxValue) {
			value = 0;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Contador: modelo (%s) y valor %d de %d", 
				model, value, maxValue);
	}
}
