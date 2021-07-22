package test_project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import test_project.model.Student;

public class Matchers {
	//TODO добавить флаги 
	//TODO добавить чтение пробела, 
	//TODO добавить фио и проверку 3ех отдельных слов 
	//TODO сделать все за 2 патерна(RU/EN)
	private static final Pattern PATTTERN = Pattern.compile("[A-Za-zА-Яа-я]+");

	public static boolean main(Student student) {
		String textName =  student.getName();

		Matcher matcherName = PATTTERN.matcher(textName);
		// System.out.println(matcher.matches());

		if (!matcherName.matches()) {
			System.out.println("Имя " + textName + " содержит некоректные символы");
			return false;
		}

		if (student.getAge() < 18) {
			System.out.println("Возраст " + student.getAge() + " указан неверно");
			return false;
		}

		if (!(student.getCourse() > 0) && !(student.getCourse() < 7)) {
			System.out.println("Курс " + student.getCourse() + " указан неверно");
			return false;
		}

		System.out.println("Все поля указаны верно");
		return true;

	}
}