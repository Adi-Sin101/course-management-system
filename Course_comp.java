import java.util.ArrayList;

public interface Course_comp
{
    public void showDetails();
}

class lesson implements Course_comp
{
    String lesson_name;
    int lesson_duration;

    lesson(String lesson_name, int lesson_duration)
    {
        this.lesson_name = lesson_name;
        this.lesson_duration = lesson_duration;
    }

    public void showDetails()
    {
        System.out.println("Lesson Name: " + lesson_name + ", Duration: " + lesson_duration + " mins");
    }

    
}

class CourseModule implements Course_comp
{
    ArrayList<lesson> Lessons = new ArrayList<>();
    String module_name;
    ArrayList<CourseModule>modules = new ArrayList<>();
    CourseModule(String module_name,ArrayList<lesson> Lessons,ArrayList<CourseModule>modules)
    {
        this.module_name = module_name;
        this.Lessons = Lessons;
        this.modules=modules;
    }
    public void showDetails()
    {
        System.out.println("Module Name: " + module_name);
        for (lesson l : Lessons)
        {
            l.showDetails();
        }
        for(CourseModule m:modules)
        {
            m.showDetails();
        }
    }
}

class Sample_course_module{
    public static void main(String[] args) {
        lesson l1 = new lesson("Introduction to Java", 30);
        lesson l2 = new lesson("OOP Concepts", 45);
        lesson l3 = new lesson("Data Structures", 40);
        ArrayList<lesson> lessons1 = new ArrayList<>();
        lessons1.add(l1);
        lessons1.add(l2);
        ArrayList<lesson> lessons2 = new ArrayList<>();
        lessons2.add(l3);
        CourseModule module1 = new CourseModule("Java Basics", lessons1,new ArrayList<>());
        CourseModule module2 = new CourseModule("Advanced Topics", lessons2,new ArrayList<>());
        ArrayList<CourseModule> subModules = new ArrayList<>();
        subModules.add(module1);
        subModules.add(module2);
        CourseModule mainCourse = new CourseModule("Complete Java Course", new ArrayList<>(),subModules);
        mainCourse.showDetails();
    }
}