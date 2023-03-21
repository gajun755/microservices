package com.java8.soted;

public class Person implements Comparable<Person>{

		private Integer id;
		private String fName;
		private String lName;
		
		public Person(Integer id, String fName, String lName) {
			super();
			this.id = id;
			this.fName = fName;
			this.lName = lName;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getfName() {
			return fName;
		}
		public void setfName(String fName) {
			this.fName = fName;
		}
		public String getlName() {
			return lName;
		}
		public void setlName(String lName) {
			this.lName = lName;
		}
		@Override
		public int compareTo(Person o) {
			
			return this.getId().compareTo(o.getId());
		}
		@Override
		public String toString() {
			return "Person [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
		}
		
		
		
}
