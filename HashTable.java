import java.util.*;

public class HashTable<E>{
	private DLList<E>[] table;
	

	public HashTable(){
		table = new DLList[20000];

		for(int i = 0; i < table.length; i++){
			table[i] = new DLList<E>();
		}
	}

	public void add(E e){
		if(!(table[e.hashCode()].size() > 0)){
			table[e.hashCode()] = new DLList();
		}
		table[e.hashCode()].add(e);
	}

	public DLList<E> get(int hash){
		return table[hash];
	}

	public String getBrand(int loc){
		return table[loc].get(0).get().toString();
	}

	public DLList<String> getBrands(){
		DLList<String> brands = new DLList();

		for(int i = 0; i < table.length; i++){
			if(table[i].size() > 0){
				brands.add(table[i].get(0).toString().substring(0,3));
			}
		}

		return brands;
	}

	public String[] getBrandsString(){
		DLList<String> brands = new DLList();

		for(int i = 0; i < table.length; i++){
			if(table[i].size() > 0){
				brands.add(table[i].get(0).toString().substring(0,3));
			}
		}

		String[] b = new String[brands.size()];

		for(int i = 0; i < brands.size(); i++){
			b[i] = brands.get(i).toString();
		}

		return b;
	}

	public String toString(){
		String str = "";
		for(int i = 0; i < table.length; i++){
			if(table[i].size() > 0){
				str += "Make " + i + ":";
				str += table[i].toString();
				str += "\n";
			}
		}
		return str;
	}
}
