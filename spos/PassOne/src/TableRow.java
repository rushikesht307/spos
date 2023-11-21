
public class TableRow {
	String symbol;
	int index,address;
	public TableRow(String symbol,int address,int index) {
		this.symbol = symbol;
		this.address = address;
		this.index = index;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index=index;
	}
	
}
