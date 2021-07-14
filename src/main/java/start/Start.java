package start;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import test_project.model.Student;



public class Start {
	public static void main(String[] args) throws IOException {
		
		
		readYaml();
		
		
		
	}

	
	
	public static void readYaml() throws IOException {
		Yaml yamlread = new Yaml();
		try (FileInputStream fileInputStream = new FileInputStream("/home/student/Documents/Project/list/students.yaml");) {
			Map<String, Object> obj = yamlread.load(fileInputStream);
			
			Object students = obj.get("students");
			List<Map<String, Object>> studentsList = (List<Map<String, Object>>) students; 
			int countermax= studentsList.size();
			for (int i =0; i<countermax; i++) {
				Map<String, Object> local = studentsList.get(i);
				
				String name = (String) local.get("name");
				boolean sex = (boolean) local.get("sex");
				int age = (int) local.get("age");
				int course = (int) local.get("course");
				
				
				Student student = new Student(name, sex, age, course);
				System.out.println(student);
			}
				
		
		}
	}

	public static void printYaml() throws IOException {
		Yaml yamlprint = new Yaml();

		Student student = new Student("Ivan", true, 21, 3);

		FileWriter writer = new FileWriter("/home/student/Documents/Project/list/students.yaml");
		yamlprint.dump(student, writer);
	}
	
}
