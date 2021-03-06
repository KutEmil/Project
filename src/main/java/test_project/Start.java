package test_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import test_project.model.Student;
import test_project.Matchers;

public class Start {
	public static void main(String[] args) throws IOException {

		//TODO Изменить на foreach
		for (int i = 0; i < args.length; i++) {
			String parArgs = args[i];
			Files.walkFileTree(Paths.get(parArgs), new MyFileVisitor());
		}
		/* /home/student/Documents/Project/list/students.yaml */
		// TODO Запустить логирование(подключить slf4j)
	}

	public static void readYaml(String parArgs) throws IOException {

		Yaml yamlread = new Yaml();
		try (FileInputStream fileInputStream = new FileInputStream(parArgs);) {

			Map<String, Object> obj = yamlread.load(fileInputStream);

			Object students = obj.get("students");

			List<Map<String, Object>> studentsList = (List<Map<String, Object>>) students;
			int countermax = studentsList.size();
			//TODO Изменить на foreach
			for (int i = 0; i < countermax; i++) {
				Map<String, Object> local = studentsList.get(i);

				//TODO Через мапу проверить что все ключи на своем месте и что их 4 штуки (map.size)
				
				//TODO  Проверка переменных должна быть тут
				//TODO  Почистить метод main(вынести все в класс над Matcher)
				
				String name = (String) local.get("name");
				boolean sex = (boolean) local.get("sex");
				int age = (int) local.get("age");
				int course = (int) local.get("course");

				Student student = new Student(name, sex, age, course);
				if(Matchers.main(student)) {
				System.out.println(student);
				}
			}

		}
	}

	static class MyFileVisitor extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			String stringName = file.getFileName().toString();
			if (stringName.endsWith(".yaml")) {
				System.out.println(file.toAbsolutePath());
				try {
					readYaml(file.toAbsolutePath().toString());
				} catch (ClassCastException e) {
					System.err.println("Error incorrect file type or content");
				}
			}
			return FileVisitResult.CONTINUE;

		}
	}

}
