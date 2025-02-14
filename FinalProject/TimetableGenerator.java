import java.util.*;

class Teacher {
    String name;
    List<String> availableSlots;

    Teacher(String name, List<String> availableSlots) {
        this.name = name;
        this.availableSlots = availableSlots;
    }
}

class Subject {
    String name;
    Teacher teacher;

    Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }
}

class Timetable {
    Map<String, Map<String, String>> schedule;
    List<String> timeSlots;

    Timetable(List<String> timeSlots) {
        this.timeSlots = timeSlots;
        schedule = new HashMap<>();
    }

    void generate(List<Subject> subjects) {
        for (String slot : timeSlots) {
            for (Subject subject : subjects) {
                if (subject.teacher.availableSlots.contains(slot) && !schedule.containsKey(slot)) {
                    schedule.put(slot, new HashMap<>());
                    schedule.get(slot).put(subject.name, subject.teacher.name);
                    break;
                }
            }
        }
    }

    void display() {
        System.out.println("Generated Timetable:");
        for (String slot : schedule.keySet()) {
            System.out.println(slot + " -> " + schedule.get(slot));
        }
    }
}

public class TimetableGenerator {
    public static void main(String[] args) {
        List<String> timeSlots = Arrays.asList("Monday 9AM", "Monday 10AM", "Tuesday 9AM", "Tuesday 10AM");
        
        Teacher t1 = new Teacher("Alice", Arrays.asList("Monday 9AM", "Tuesday 10AM"));
        Teacher t2 = new Teacher("Bob", Arrays.asList("Monday 10AM", "Tuesday 9AM"));
        
        List<Subject> subjects = Arrays.asList(
            new Subject("Math", t1),
            new Subject("Physics", t2)
        );
        
        Timetable timetable = new Timetable(timeSlots);
        timetable.generate(subjects);
        timetable.display();
    }
}
