package jobdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test_1526 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			if(n == 0)
				break;
			int m = in.nextInt();
			Person[] persons = new Person[n];
			for(int i=0; i<n; i++) {
				persons[i] = new Person(i+1);
			}
			for(int i=0; i<m; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				persons[a-1].friends.add(persons[b-1]);
				persons[b-1].friends.add(persons[a-1]);
			}
			int count = 0;
			for(int i=0; i<n; i++) {
				count += DFS(persons[i]);
			}
			System.out.println(count);
		}
	}
	
	public static int DFS(Person person) {
		if(person.visited)
			return 0;
		else {
			person.visited = true;
			List<Person> friends = person.friends;
			for(int i=0; i<friends.size(); i++) {
				DFS(friends.get(i));
			}
		}
		return 1;
	}

}


class Person {
	int num;
	List<Person> friends;
	boolean visited;
	public Person(int num) {
		this.num = num;
		this.friends = new ArrayList<Person>();
		this.visited = false;
	}
}